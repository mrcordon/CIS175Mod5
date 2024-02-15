/*
 *  Mike Cordon - mrcordon@dmacc.com
 *  CIS175 Java 2
 *  Module 5 Assignment - JPA/Servlet/JSP
 *  FILE: ViewAllDogsServlet.java
	02/15/24
 */

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewAllDogsServlet
 */
@WebServlet("/viewAllDogsServlet")
public class ViewAllDogsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllDogsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// instantiate data access object
		DogHelper dao = new DogHelper();
		
		request.setAttribute("allDogs", dao.showAllDogs());
		
		String path = "/web-dogs.jsp";
		// if table is empty
		if(dao.showAllDogs().isEmpty()) {
			path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
