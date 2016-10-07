package handout11;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/lista")
public class Lista extends HttpServlet {

    protected void service (HttpServletRequest request,
                            HttpServletResponse response)
            throws  ServletException, IOException {

		DAO dao = new DAO();

		List<Pessoas> pessoas = dao.getLista();
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><table border='1'>");
		out.println("<tr><td>ID</td><td>Nome</td>" + 
                    "<td>Nascimento</td><td>Altura</td></tr>");
		for (Pessoas pessoa : pessoas) {
	         out.println("<tr><td>" + pessoa.getId() + "</td>");
	         out.println("<td>" + pessoa.getNome() + "</td>");
	         out.println("<td>" + pessoa.getNascimento().getTime() + "</td>");
	         out.println("<td>" + pessoa.getAltura() + "</td></tr>");	         
		}
		out.println("</table>");
        
		List<Passaportes> passaportes = dao.getListaPassaportes();
		
		out.println("<table border='1'>");
		out.println("<tr><td>ID</td><td>pessoa_id</td>" + 
					"<td>pais</td><td>validade</td></tr>");
		for (Passaportes passaporte : passaportes) {
			out.println("<tr><td>" + passaporte.getId() + "</td>");
			out.println("<td>" + passaporte.getPessoa_id() + "</td>");
			out.println("<td>" + passaporte.getPais() + "</td>");
			out.println("<td>" + passaporte.getValidade().getTime() + "</td></tr>");
		}
		out.println("</table></body></html>");
		
		dao.close();
        
    } 
}
