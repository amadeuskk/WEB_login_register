package web_redirect;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class redirect
 */
public class redirect extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public redirect() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//告知客户端进行重定向
//		//	设置状态码302
//		response.setStatus(302);
//		// 设置响应头 Location
//		response.setHeader("Location", "/WEB13/login.html");
		//	设置定时刷新的头
//		response.setHeader("refresh", "5;url=http://www.baidu.com");
	  
		// 有完整封装的重定向方法sendRedirect(url) 自动返回状态码和 重定向
		response.sendRedirect("/WEB13/login.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
