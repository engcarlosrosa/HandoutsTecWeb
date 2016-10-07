package handout11;

import java.util.Calendar;

public class Passaportes {
	private Integer id;
	private Integer pessoa_id;
	private String pais;
	private Calendar validade;
	
	public Integer getId() {return this.id;}
	public void setId(Integer id) {this.id = id;}
	
	public Integer getPessoa_id() {return this.pessoa_id;}
	public void setPessoa_id(Integer pessoa_id) {this.pessoa_id = pessoa_id;}
	
	public String getPais() {return this.pais;}
	public void setPais(String pais) {this.pais = pais;}
	
	public Calendar getValidade() {return this.validade;}
	public void setValidade(Calendar validade) {this.validade = validade;}

}
