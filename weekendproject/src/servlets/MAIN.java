package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MAIN
 */
@WebServlet("/MAIN")
public class MAIN extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String link = "Home.jsp";
		if (request.getParameter("projects")!=null) {
			link = "Projects.jsp";
		}
		if (request.getParameter("about")!=null) {
			link = "About.jsp";
		}
		if (request.getParameter("brntzn")!=null) {
			link = "Brntzn.jsp";
		}
		if (request.getParameter("pathfinder")!=null) {
			link = "PathHome.jsp";
		}
		if (request.getParameter("rij")!=null) {
			link = "Rij.jsp";
		}
		if (request.getParameter("minesweeper")!=null) {
			link = "Minesweeper.jsp";
		}
		RequestDispatcher dis = request.getRequestDispatcher(link);
		dis.forward(request, response);
	}

}
