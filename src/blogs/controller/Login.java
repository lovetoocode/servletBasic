package blogs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import blogs.modal.LoginModal;

import blogs.beans.Blogger;
/**name
 * Servlet implementation class Login
 */

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
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
		if(username!=null&&password!=null&&username!=""&&password!="") {
			LoginModal l = new LoginModal();
			try {
				HttpSession session = request.getSession();
				Blogger Login = l.Login(request);
				if(Login!=null) {
					session.setAttribute("blogger", Login);
					response.sendRedirect(request.getContextPath());
				}else {
					request.setAttribute("message", "Invalid username or password");
					RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
					dispatcher.forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			request.setAttribute("message", "Username & password must");
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
