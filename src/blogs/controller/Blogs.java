package blogs.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import blogs.modal.BlogsModal;
import java.util.ArrayList;
import java.util.List; 
import blogs.controller.Blog;

/**
 * Servlet implementation class Blogs
 */
public class Blogs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Blogs() {
        super();
        // TODO Auto-generated constructor stub
    }   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */     
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String registrationId = (String) request.getParameter("blogger");
    	ArrayList<blogs.beans.Blogs> blogs = null;
    	try {
    		blogs = new BlogsModal().Blogs(registrationId);
		} catch (SQLException e) {	
			e.printStackTrace();
		}   
    	HttpSession session = request.getSession();
    	request.setAttribute("blogsList", blogs);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogs.jsp");
		dispatcher.forward(request, response);
	}   

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
