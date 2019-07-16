package blogs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import java.sql.Connection;
import java.sql.SQLException;

import blogs.modal.RegisterModal;
/**name
 * Servlet implementation class Login
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/register.jsp");
		dispatcher.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String rePassword = request.getParameter("repassword");
		if(password.equals(rePassword)) {
			try {
				RegisterModal register = new RegisterModal();
				int registration = register.Registration(request);
				if(registration == 1) {
					response.sendRedirect(request.getContextPath());
				}else {
					request.setAttribute("message", "Duplicate Entry");
					RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/register.jsp");
					dispatcher.forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else { 
			request.setAttribute("message", "Password Mismatch");
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/register.jsp");
			dispatcher.forward(request, response);
		}

	}

}
