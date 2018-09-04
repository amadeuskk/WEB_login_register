package com.itheima.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.print.attribute.standard.PrinterLocation;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.sun.xml.internal.ws.message.EmptyMessageImpl;

import mysql.function.Con_Function;
import mysql.function.Con_Pool;

/**
 * Servlet implementation class Login_register
 */
public class Login_register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
    public void init() throws ServletException {
    	ServletContext servletContext = this.getServletContext();
    	servletContext.setAttribute("num", 1);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 首先获取验证码，并且判断是否正确
		HttpSession session=request.getSession();
		String session_yzm = (String) session.getAttribute("yzm");
		String yzm = request.getParameter("verification");
		System.out.println(session_yzm);
		System.out.println(yzm);
		if(session_yzm.equals(yzm)) {
			// 处理网页的post请求
			// 首先获取网页post的信息 username password
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			// 使用自建连接池的con 执行select语句，如果有数据则输出其email,如果没数据则输出”帐号或密码错误“
			// 从自建连接池方法（之后可以选择使用C3P0连接池或者DBUnit）获取连接con
			Connection con = null;
			Con_Pool pool = new Con_Pool();
			try {
				con = (Connection)pool.getConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String sql = "select * from WEB13 where username = ? and password = ?";
			// 使用PreparedStatement预编译来执行con的操作
			PreparedStatement pre = null;
			try {
				pre = (PreparedStatement) con.prepareStatement(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ResultSet result = null;
			try {
				ServletContext servletContext = this.getServletContext();
				int num = (int) servletContext.getAttribute("num");
				pre.setString(1, username);
				pre.setString(2, password);
				result =pre.executeQuery();
				if(result != null){
				    if(result.next()) {
				    	Object email = result.getObject(3);
				    	response.getWriter().write((String)email);
				    	response.getWriter().write("</br>");
				    	response.getWriter().write("the:"+num);
				    	num += 1;
				    	servletContext.setAttribute("num", num);
				    }else {
						response.getWriter().write("wrong account");
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pool.backConnection(con);
		}else {
			response.getWriter().write("error");
		}
	}
}
