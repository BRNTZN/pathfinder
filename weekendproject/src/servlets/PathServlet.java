package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Pathfinder;

/**
 * Servlet implementation class PathServlet
 */
@WebServlet("/PathServlet")
public class PathServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Integer NUL = new Integer(0), ……N = new Integer(1);

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String link = "PathHome.jsp";
		if (request.getParameter("meerX") != null || request.getParameter("meerY") != null
				|| request.getParameter("sbmt") != null) {
			List<List<Integer>> grid = (List<List<Integer>>) request.getSession().getAttribute("grid");
			int xVal = grid.get(0).size();
			int yVal = grid.size();
			for (int y = 0; y <= yVal; y++) {
				for (int x = 0; x <= xVal; x++) {
					if (request.getParameter(x + "name" + y) != null) {
						grid.get(y).remove(x);
						grid.get(y).add(x, NUL);
					}
				}
			}
			request.getSession().setAttribute("list", grid);
		}

		if (request.getParameter("meerX") != null) {
			List<List<Integer>> grid = (List<List<Integer>>) request.getSession().getAttribute("grid");
			for (List<Integer> list : grid) {
				list.add(……N);
			}
		}
		if (request.getParameter("meerY") != null) {
			List<List<Integer>> grid = (List<List<Integer>>) request.getSession().getAttribute("grid");
			List<Integer> newRow = new ArrayList<Integer>();
			for (int i = 0; i < grid.get(0).size(); i++) {
				newRow.add(……N);
			}
			grid.add(newRow);
		}
		
		if (request.getParameter("start") != null) {
			String location = request.getParameter("start");
			String[] c = location.split("value");
			int x = Integer.parseInt(c[0]);
			int y = Integer.parseInt(c[1]);
			List<List<Integer>> grid = (List<List<Integer>>)request.getSession().getAttribute("grid");
			List<Integer> row = grid.get(y);
			row.remove(x);
			row.add(x, 2);
			request.getSession().setAttribute("grid", grid);
			request.getSession().setAttribute("phase", 3);
		}
		
		if (request.getParameter("end") != null) {
			String location = request.getParameter("end");
			String[] c = location.split("value");
			int x = Integer.parseInt(c[0]);
			int y = Integer.parseInt(c[1]);
			List<List<Integer>> grid = (List<List<Integer>>)request.getSession().getAttribute("grid");
			List<Integer> row = grid.get(y);
			row.remove(x);
			row.add(x, 3);
			Pathfinder p = new Pathfinder();
			request.getSession().setAttribute("grid", p.find(grid));
			request.getSession().setAttribute("phase", 4);
		}
		
		if (request.getParameter("back")!=null) {
			int phase = Integer.parseInt(request.getSession().getAttribute("phase").toString());
			request.getSession().setAttribute("phase", phase-1);
		}
		
		if (request.getParameter("refresh") != null) {
			request.getSession().invalidate();
		}
		if (request.getParameter("clear") != null) {
			request.getSession().setAttribute("phase", 1);
			List<List<Integer>> grid = (List<List<Integer>>)request.getSession().getAttribute("grid");
			for (int i = 0; i < grid.size(); i++) {
				List<Integer> row = grid.get(i);
				for (int j = 0; j < grid.get(0).size(); j++) {
					row.remove(j);
					row.add(……N);
				}
			}
		}
		if (request.getParameter("sbmt") != null) {
			request.getSession().setAttribute("phase", 2);
		}

		RequestDispatcher dis = request.getRequestDispatcher(link);
		dis.forward(request, response);
	}
	
}
