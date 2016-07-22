package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import customTools.CourseDB;
import model.Henrollment;

/**
 * Servlet implementation class EditGrade
 */
@WebServlet("/EditGrade")
public class EditGrade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditGrade() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nextURL = "/error.jsp";
		String grade = request.getParameter("grade");
		
		long enrollmentid = Long.parseLong(request.getParameter("enrollmentid"));

		if (CourseDB.SetGrade(enrollmentid, grade)) {		
			//nextURL = "/viewroster.jsp";
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
