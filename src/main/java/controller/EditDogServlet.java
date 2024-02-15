/*
 *  Mike Cordon - mrcordon@dmacc.com
 *  CIS175 Java 2
 *  Module 5 Assignment - JPA/Servlet/JSP
 *  FILE: EditDogServlet.java
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
 * Servlet implementation class EditDogServlet
 */
@WebServlet("/editDogServlet")
public class EditDogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDogServlet() {
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
		// instantiation of data access object
		DogHelper dao = new DogHelper();
		// variables
		String name = request.getParameter("name");
		String breed = request.getParameter("breed");
		String color = request.getParameter("color");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		// setting information of the dog to edit
		Dogs dogToUpdate = dao.searchForDogById(tempId);
		dogToUpdate.setName(name);
		dogToUpdate.setBreed(breed);
		dogToUpdate.setColor(color);
		// updating the dog with dao
		dao.updateDog(dogToUpdate);
		// send user to viewAllDogsServlet
		getServletContext().getRequestDispatcher("/viewAllDogsServlet").forward(request, response);
		
	}

}
