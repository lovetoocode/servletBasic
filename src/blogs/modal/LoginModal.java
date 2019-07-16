package blogs.modal;

import blogs.connection.MysqlConnection;
import blogs.constant.Constants;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import blogs.beans.Blogger;

import javax.servlet.http.HttpServletRequest;
public class LoginModal {
	private static Connection conn = null;
	public LoginModal() {
		try {
			conn = MysqlConnection.getMySQLConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public Blogger Login(HttpServletRequest request) throws SQLException {
		String sql = "SELECT full_name, email, MD5(registration_id) as registration_id  FROM "+Constants.registrationTable+" where email = ? AND password = MD5(?)";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, request.getParameter("username"));
        pstm.setString(2, request.getParameter("password"));
        ResultSet rs = pstm.executeQuery();
        if(rs.first()) {
        	Blogger blogger = new Blogger();
        	blogger.setRegistrationId(rs.getString("registration_id"));
        	blogger.setEmail(rs.getString("email"));
        	blogger.setFullName(rs.getString("full_name"));
        	return blogger;
        }
        return null;
        
	}
}
