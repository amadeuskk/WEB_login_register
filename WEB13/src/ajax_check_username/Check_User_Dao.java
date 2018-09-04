package ajax_check_username;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.domain.UserBean;

import mysql.function.C3P0_pool_Function;

public class Check_User_Dao {
	public static boolean CheckUser(String username) {
		// 通过数据库查询用户名，如存在则返回true,不存在则返回false
		QueryRunner qr=new QueryRunner(C3P0_pool_Function.getDataSource());
		String sql = "select count(*) from WEB13 where username = ?";
		String[] params = {username};
		try {
			Long user_num = qr.query(sql, new ScalarHandler<Long>(),params);
			if(user_num == 0) {
				return false;
			}else {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
