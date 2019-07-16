package blogs.modal;

import blogs.connection.MysqlConnection;
import blogs.constant.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

import blogs.beans.Blogs;

public class BlogsModal {
	private static Connection conn = null;

	public BlogsModal() {
		try {
			conn = MysqlConnection.getMySQLConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Blogs> Blogs(String registrationId) throws SQLException {
		String where = "";
		if (registrationId != null) {
			where = " WHERE b.registration_id = ?";
		}
		String sql = "SELECT b.id, a.full_name, b.title, b.description, DATE_FORMAT(b.created_date, '%d-%m-%Y %h:%i %p') as created_date FROM "
				+ Constants.blogTable + " AS b LEFT JOIN " + Constants.registrationTable
				+ " AS a ON b.registration_id = MD5(a.registration_id)" + where + " order by b.created_date DESC";
		PreparedStatement pstm = conn.prepareStatement(sql);
		if (registrationId != null)
			pstm.setString(1, registrationId);
		ResultSet rs = pstm.executeQuery();
		ArrayList<Blogs> blogs = new ArrayList<Blogs>();
		while (rs.next()) {
			int id = rs.getInt("id");
			String full_name = rs.getString("full_name");
			String title = rs.getString("title");
			String description = rs.getString("description");
			String created_date = rs.getString("created_date");
			Blogs blog = new Blogs();
			blog.setId(id);
			blog.setAuthor(full_name);
			blog.setTitle(title);
			blog.setDescription(description);
			blog.setDate(created_date);
			blogs.add(blog);
		}
		return blogs;
	}
}
