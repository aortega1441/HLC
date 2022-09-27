package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DbConnection;
import dao.VacanteDao;
import modelo.Vacante;

/**
 * Servlet implementation class VacanteControlador
 */
public class VacanteControlador extends HttpServlet {
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Vacante vacante= new Vacante(0);
		String nombreParam= request.getParameter("nombre");
		vacante.setNombre(nombreParam);
		String descripcionParam=request.getParameter("descripcion");
		vacante.setDescripcion(descripcionParam);
		String detalleParam=request.getParameter("detalle");
		vacante.setDetalle(detalleParam);
		//System.out.println(vacante);
		
		DbConnection conn=new DbConnection();
		
		VacanteDao vacanteDao= new VacanteDao(conn);
		boolean status = vacanteDao.insert(vacante);
		
		String msg="";
		
		if (status) {
			
			msg="La vacante fue guardada correctamente. ";
			
		} else {
			
			msg="Ocurrio un error. La vacante no fue guardada.";

		}
		
		conn.disconnect();
		RequestDispatcher rd;
		
		request.setAttribute("message", msg);
		rd=request.getRequestDispatcher("mensaje.jsp");
		rd.forward(request, response);
		
		
		
	}

}
