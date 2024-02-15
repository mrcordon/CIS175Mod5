/*
 *  Mike Cordon - mrcordon@dmacc.com
 *  CIS175 Java 2
 *  Module 5 Assignment - JPA/Servlet/JSP
 *  FILE: AddDogServlet.java
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
 * Servlet implementation class AddDogServlet
 */
@WebServlet("/addDogServlet")
public class AddDogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDogServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// variables
		String name = request.getParameter("name");
		String breed = request.getParameter("breed");
		String color = request.getParameter("color");
		// instantiate dog to add
		Dogs d = new Dogs(name, breed, color);
		// add dog with dao
		DogHelper dao = new DogHelper();
		dao.insertDog(d);
		// reload home page
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
