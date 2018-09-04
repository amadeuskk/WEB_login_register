package ajax_check_username;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Check_User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Check_User() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取网页传给的username
		String username = request.getParameter("username");
		// server层，将username传入server层（管理层，实现不同需求用不同servlet），获取一个boolean数据显示用户名是否存在
		Boolean flag = Check_User_Servlet.checkUser(username);
		// 将获取的flag返回以json形式给网页
		response.getWriter().println("{\"flag\":"+flag+"}");
	}

}
