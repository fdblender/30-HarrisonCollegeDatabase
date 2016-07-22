package Servlets;

import java.io.IOException;
import java.math.BigDecimal;
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
 * Servlet implementation class Portal
 */
@WebServlet("/Portal")
public class Portal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Portal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String nextURL = "";
		Huser user = null;
		HttpSession session = request.getSession();
		user = (Huser) session.getAttribute("user"); 		
		List<Hclass> classes = null;
		List<Henrollment> enrollment = null;
		BigDecimal i = user.getIsinstructor();
		
		System.out.println("Value of Isinstructor: "+i);
				
		if (i.intValue() == 1) {				
				System.out.println("getting classes for instructor");
				classes = CourseDB.getClassesForInstructor(user.getUserid());
				session.setAttribute("classes", classes);
				nextURL = "/instructorportal.jsp";
			
		} else {
			System.out.println("getting classes for student");
			enrollment = CourseDB.getClassesForStudent(user.getUserid());
			session.setAttribute("enrollment", enrollment);
			nextURL = "/studentportal.jsp";
		}
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
