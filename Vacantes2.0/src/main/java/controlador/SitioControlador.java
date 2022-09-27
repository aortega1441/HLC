package controlador;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DbConnection;
import dao.VacanteDao;
import modelo.Vacante;

/**
 * Servlet implementation class SitioControlador
 */
public class SitioControlador extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd;
		DbConnection conn = new DbConnection();
		VacanteDao vacanteDao= new VacanteDao(conn);
		
		List<Vacante> lista = vacanteDao.getUltimas();
		
		conn.disconnect();
		
		request.setAttribute("ultimas", lista);
		rd=request.getRequestDispatcher("/index.jsp");
		rd.forward(request, response);
		
		
		
	}

	

}
