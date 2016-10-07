package handout11;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/atualizapassaporte")
public class AtualizaPassaporte extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
	throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<form method='post'>");
		out.println("ID: <input type='number' name='id'><br>");
		out.println("Pessoa_ID: <input type='number' name='pessoa_id'><br>");
		out.println("Pais: <input type='text' name='pais'><br>");
		out.println("Validade: <input type='date' name='validade'><br>");
		out.println("<input type='submit' value='Submit'>");
		out.println("</form>");
		out.println("<body><html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response)
	throws ServletException, IOException {
		DAO dao = new DAO();
		
		Passaportes passaporte = new Passaportes();
		passaporte.setId(Integer.valueOf(request.getParameter("id")));
		passaporte.setPessoa_id(Integer.valueOf(request.getParameter("pessoa_id")));
		passaporte.setPais(request.getParameter("pais"));
		
		String validade = request.getParameter("validade");
		Date data;
		try {
			data = new SimpleDateFormat("yyyy-MM-dd").parse(validade);
			Calendar dataValidade = Calendar.getInstance();
			dataValidade.setTime(data);
			
			passaporte.setValidade(dataValidade);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dao.alteraPassaporte(passaporte);
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("atualizado" + passaporte.getPais());
		out.println("</body><html>");
		
		dao.close();
	}

}
