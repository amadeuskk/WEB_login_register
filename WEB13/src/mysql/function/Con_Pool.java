package mysql.function;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

import com.mysql.jdbc.Connection;
import com.sun.istack.internal.Pool;

public class Con_Pool  implements DataSource{
//	创建连接池体
	private static LinkedList<Connection> pool = new LinkedList<Connection>();
	static {
//		创建四个连接
		for(int i = 0;i<4;i++) {
			Connection con = Con_Function.getReasource();
			pool.add(con);			
		}
	}
	
	public java.sql.Connection getConnection() throws SQLException {
		Connection con = null;
		if(pool.size() == 0) {
//			当连接池中的连接为0时，紧急创建四个新的连接加入到连接池中
			for(int i = 0;i<4;i++) {
				con = Con_Function.getReasource();
				pool.add(con);
				}
		}
//		从连接池中拿取连接
		con = pool.removeFirst();
		return con;
	}
	
//定义backConnection方法,让连接使用完后归还到连接池
	public void backConnection(Connection con) {
		pool.add(con);
	}
	
	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public java.sql.Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
