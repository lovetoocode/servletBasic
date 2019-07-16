package blogs.modal;

import blogs.connection.MysqlConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import blogs.constant.Constants;

import javax.servlet.http.HttpServletRequest;

public class RegisterModal {
	private static Connection conn = null;
	public RegisterModal() {
		try {
			conn = MysqlConnection.getMySQLConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public int Registration(HttpServletRequest request) throws SQLException {
		String sql = "INSERT INTO "+Constants.registrationTable+"(email, password) values (?,MD5(?))";
		 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, request.getParameter("username"));
        pstm.setString(2, request.getParameter("password"));
 
        return pstm.executeUpdate();
	}
}
