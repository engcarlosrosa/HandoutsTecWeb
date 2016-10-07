package handout11;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DAO {
	private Connection connection = null;
	public DAO() {
	    try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/meus_dados2", "root", "123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void adiciona(Pessoas pessoa) {
		String sql = "INSERT INTO Pessoas" +
		"(nome,nascimento,altura) values(?,?,?)";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1,pessoa.getNome());
			if(pessoa.getNascimento()==null) {
			     stmt.setDate(2, new Date(Calendar.getInstance().getTimeInMillis()));
			} else {
				stmt.setDate(2, new Date(pessoa.getNascimento().getTimeInMillis()));
			}
			stmt.setDouble(3,pessoa.getAltura());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void adicionaPassaporte(Passaportes passaporte) {
		String sql = "INSERT INTO Passaportes" + 
				"(pessoa_id, pais, validade) values(?,?,?)";
		PreparedStatement stmt;
		try{
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, passaporte.getPessoa_id());
			stmt.setString(2, passaporte.getPais());
			stmt.setDate(3, new Date(passaporte.getValidade().getTimeInMillis()));
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Pessoas> getLista() {

		List<Pessoas> pessoas = new ArrayList<Pessoas>();

		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("SELECT * FROM Pessoas");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Pessoas pessoa = new Pessoas();
				pessoa.setId(rs.getInt("id"));
				pessoa.setNome(rs.getString("nome"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("nascimento"));
				pessoa.setNascimento(data);
				pessoa.setAltura(rs.getDouble("altura"));
				pessoas.add(pessoa);
			}
			rs.close();
			stmt.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return pessoas;
	}
	
	public List<Passaportes> getListaPassaportes() {
		
		List<Passaportes> passaportes = new ArrayList<Passaportes>();
		
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("SELECT * FROM Passaportes");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Passaportes passaporte = new Passaportes();
				passaporte.setId(rs.getInt("id"));
				passaporte.setPessoa_id(rs.getInt("pessoa_id"));
				passaporte.setPais(rs.getString("pais"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("validade"));
				passaporte.setValidade(data);
				passaportes.add(passaporte);
			}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return passaportes;
		
				
			}
	
	public void altera(Pessoas pessoa) {
		String sql = "UPDATE Pessoas SET " +
	          "nome=?, nascimento=?, altura=? WHERE id=?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, pessoa.getNome());
			stmt.setDate(2, new Date(pessoa.getNascimento().getTimeInMillis()));
			stmt.setDouble(3, pessoa.getAltura());
			stmt.setInt(4, pessoa.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void alteraPassaporte (Passaportes passaporte){
		String sql = "UPDATE Passaportes SET " + 
				"pessoa_id=?, pais=?, validade=? WHERE id=?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, passaporte.getPessoa_id());
			stmt.setString(2, passaporte.getPais());
			stmt.setDate(3, new Date(passaporte.getValidade().getTimeInMillis()));
			stmt.setInt(4, passaporte.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void remove(Integer id) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("DELETE FROM Pessoas WHERE id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void removePassaporte(Integer id) {
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement("DELETE FROM Passaportes WHERE id=?");
			stmt.setLong(1, id);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
