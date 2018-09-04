package ajax_check_username;

public class Check_User_Servlet {
	// 此servlet 层只有一个方法
	public static boolean checkUser(String username) {
		// 进入dao层(操作数据库),查询username是否存在
		Boolean flag = Check_User_Dao.CheckUser(username);
		return flag;
	}
}
