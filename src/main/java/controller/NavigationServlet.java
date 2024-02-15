/*
 *  Mike Cordon - mrcordon@dmacc.com
 *  CIS175 Java 2
 *  Module 5 Assignment - JPA/Servlet/JSP
 *  FILE: NavigationServlet.java
	02/15/24
 */

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Dogs;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavigationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// instantiate data access object
		DogHelper dao = new DogHelper();
		// variables
		String act = request.getParameter("doThisToDog");
		String path = "/viewAllDogsServlet";
		
		if(act.equals("delete")) {  // delete is selected
			try {
				// delete a dog from the database
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Dogs dogToDelete = dao.searchForDogById(tempId);
				dao.deleteDog(dogToDelete);
			} catch(NumberFormatException e) {
				System.out.println("Forgot to select an item");
			}
		} else if(act.equals("edit")) {  // edit is selected
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Dogs dogToEdit = dao.searchForDogById(tempId);
				request.setAttribute("dogToEdit", dogToEdit);
				path = "/edit-dog.jsp";
			} catch(NumberFormatException e) {
				System.out.println("Forgot to select an item");
			}
		} else if(act.equals("add")) {  // add is selected
			path = "/index.html";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
