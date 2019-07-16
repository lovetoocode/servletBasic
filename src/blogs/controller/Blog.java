package blogs.controller;

import java.io.IOException;

import java.sql.SQLException;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import java.io.File;

import blogs.beans.Blogger;
import blogs.beans.Blogs;

import service.Session;
import service.fileUploader;

import blogs.modal.BlogModal;

import blogs.constant.*;

/**
 * Servlet implementation class Blog
 */
@WebServlet("/Blog")
@MultipartConfig
public class Blog extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (session.getAttribute("blogger") instanceof Blogger) {
			if(request.getParameter("method")!=null&&((String)request.getParameter("method")).equals("DELETE")) {
				doDelete(request,response);
				return;
			}
			int blogId = 0;
			if (request.getParameter("blogId") != null) {
				blogId = Integer.parseInt(request.getParameter("blogId"));
			}
			BlogModal blogInstance = new BlogModal();
			if (blogId != 0) {
				try {
					Blogs getBlog = blogInstance.getBlogDetails(blogId);
					if (getBlog != null) {
						request.setAttribute("blogDetails", getBlog);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/blog.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Blogger blogger = (Blogger) session.getAttribute("blogger");
		String registrationId = null;
		if (!new Session().loginCheck(blogger)) {
			response.sendRedirect(request.getContextPath());
		} else {
			if (request.getParameter("id")!=null && !request.getParameter("id").equals("")) {
				doPut(request, response);
				return;
			}
			System.out.println(System.getProperty("user.dir"));
			System.out.println(request.getContextPath());
			String path = getServletContext().getRealPath("") + File.separator + Constants.BLOG_IMAGE_UPLOAD_DIRECTORY;
			Part filePart = request.getPart("file");
			fileUploader fileUploaderInstance = new fileUploader();
			if(fileUploaderInstance.upload(path, filePart) == 0) {
				Blogs oldBlogData = new Blogs();
				oldBlogData.setTitle(request.getParameter("title"));
				oldBlogData.setDescription(request.getParameter("description"));
				request.setAttribute("error", "File cannont be uploaded");
				request.setAttribute("blogDetails", oldBlogData);
				RequestDispatcher dispatcher = this.getServletContext()
						.getRequestDispatcher("/WEB-INF/views/blog.jsp");
				dispatcher.forward(request, response);
			}else {
				registrationId = blogger.getRegistrationId();
				String title = (String) request.getParameter("title");
				String description = (String) request.getParameter("description");
				BlogModal blogInstance = new BlogModal();
				try {
					int blogInsert = blogInstance.BlogUpdateOrInsert(registrationId, title, description, 0);
					if (blogInsert == 1) {
						response.sendRedirect(request.getContextPath() + "?blogger=" + registrationId);
					} else {
						request.setAttribute("error", "Something Went Wrong Try Again...");
						RequestDispatcher dispatcher = this.getServletContext()
								.getRequestDispatcher("/WEB-INF/views/blog.jsp");
						dispatcher.forward(request, response);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Blogger blogger = (Blogger) session.getAttribute("blogger");
		String registrationId = null;
		if (!new Session().loginCheck(blogger)) {
			response.sendRedirect(request.getContextPath());
		} else {
			registrationId = blogger.getRegistrationId();
			String title = (String) request.getParameter("title");
			String description = (String) request.getParameter("description");
			int id = Integer.parseInt(request.getParameter("id"));
			BlogModal blogInstance = new BlogModal();
			try {
				int blogUpdate = blogInstance.BlogUpdateOrInsert(registrationId, title, description, id);
				if (blogUpdate == 1) {
					response.sendRedirect(request.getContextPath() + "?blogger=" + registrationId);
				} else {
					request.setAttribute("message", "Something Went Wrong Try Again...");
					RequestDispatcher dispatcher = this.getServletContext()
							.getRequestDispatcher("/WEB-INF/views/blog.jsp");
					dispatcher.forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Blogger blogger = (Blogger) session.getAttribute("blogger");
		String registrationId = null;
		if (!new Session().loginCheck(blogger)) {
			response.sendRedirect(request.getContextPath());
		} else {
			registrationId = blogger.getRegistrationId();
			int id = Integer.parseInt(request.getParameter("blogId"));
			BlogModal blogInstance = new BlogModal();
			try {
				int blogDelete = blogInstance.deleteBlog(id);
				if (blogDelete == 1) {
					response.sendRedirect(request.getContextPath() + "?blogger=" + registrationId);
				} else {
					request.setAttribute("message", "Something Went Wrong Try Again...");
					RequestDispatcher dispatcher = this.getServletContext()
							.getRequestDispatcher("/WEB-INF/views/blogs.jsp");
					dispatcher.forward(request, response);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	


}
