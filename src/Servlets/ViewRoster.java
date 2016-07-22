package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import customTools.CourseDB;
import model.Huser;
import model.Hclass;
import model.Henrollment;

/**
 * Servlet implementation class ViewRoster
 */
@WebServlet("/ViewRoster")
public class ViewRoster extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewRoster() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nextURL = "";
		//Huser user = null;
		HttpSession session = request.getSession();
		//user = (Huser) session.getAttribute("user"); 		
		
		Hclass section = null;
		
		List<Henrollment> enrollment = null; 		

		long classid = Long.parseLong(request.getParameter("classid"));		
		
		section = CourseDB.getClass(classid);
		
		if (section != null) {
			enrollment = CourseDB.getStudentsEnrolledInClass(classid);
		}
		session.setAttribute("section", section);
		session.setAttribute("enrollment", enrollment);
		nextURL = "/viewroster.jsp";
		response.sendRedirect(request.getContextPath() + nextURL);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
