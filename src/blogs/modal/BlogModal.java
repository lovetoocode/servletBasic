package blogs.modal;

import blogs.connection.MysqlConnection;
import blogs.constant.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import blogs.beans.Blogs;

public class BlogModal {
	private static Connection conn = null;

	public BlogModal() {
		try {
			conn = MysqlConnection.getMySQLConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public int BlogUpdateOrInsert(String registrationId, String title, String description, int id) throws SQLException {
		if (id == 0) {
			String sql = "INSERT INTO $table (`registration_id`, `title`, `description`) VALUES (?,?,?)";
			sql = sql.replace("$table", Constants.blogTable);
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, registrationId);
			pstm.setString(2, title);
			pstm.setString(3, description);
			return pstm.executeUpdate();
		} else {
			String sql = "UPDATE $table SET title = ?, description = ? WHERE id = ?";
			sql = sql.replace("$table", Constants.blogTable);
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, title);
			pstm.setString(2, description);
			pstm.setInt(3, id);
			return pstm.executeUpdate();
		}

	}
	public int deleteBlog(int id) throws SQLException {
			String sql = "DELETE FROM $table WHERE id = ?";
			sql = sql.replace("$table", Constants.blogTable);
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			return pstm.executeUpdate();
	}

	public Blogs getBlogDetails(int id) throws SQLException {
		String sql = "SELECT title,description FROM $table WHERE id = ?";
		sql = sql.replace("$table", Constants.blogTable);
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, id);
		ResultSet result = pstm.executeQuery();
		Blogs blog = new Blogs();
		if (result.next()) {
			String title = result.getString("title");
			String description = result.getString("description");
			blog.setId(id);
			blog.setTitle(title);
			blog.setDescription(description);
			return blog;
		}
		return null;
	}
}