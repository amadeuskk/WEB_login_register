package mysql.function;

import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0_pool_Function {
	private static ComboPooledDataSource dataSource =  new ComboPooledDataSource();
	public static ComboPooledDataSource getDataSource() {
		return dataSource;
	}
	public static java.sql.Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public static void main(String args[]) {
		System.out.println(dataSource);
	}
}
