package mysql.function;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.print.attribute.standard.PrinterLocation;

import com.mysql.jdbc.Connection;

public class Con_Function {
		public static Connection getReasource() {
				Connection con = null;
				ResourceBundle rb = ResourceBundle.getBundle("mysql.function/db");
				String driver = rb.getString("local.driver");
				String url = rb.getString("local.url");
				String user = rb.getString("local.user");
				String password = rb.getString("local.password");
				try {
					Class.forName(driver);
					con = (Connection) DriverManager.getConnection(url, user, password);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return con;
		}
}
