package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customTools.CourseDB;
import customTools.DBFunctions;
import model.Henrollment;

/**
 * Servlet implementation class DropClass
 */
@WebServlet("/DropClass")
public class DropClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DropClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nextURL = "/error.jsp";		
		
		long enrollmentid = Long.parseLong(request.getParameter("enrollmentid"));
		Henrollment enrollment = CourseDB.getEnrollment(enrollmentid);

		if (enrollment != null) {		
			DBFunctions.remove(enrollment);;
			nextURL = "/ViewRoster";
		}
		request.getRequestDispatcher(nextURL).forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
