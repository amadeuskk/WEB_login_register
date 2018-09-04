package com.itheima.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.dbutils.QueryRunner;

import mysql.function.C3P0_pool_Function;

public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public register() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String sql = "insert into WEB13(username,password,email) values (?,?,?)";
		String yzm = request.getParameter("verification");
		System.out.println(yzm);
		String[] params = {username,password,email};		
		
		//判断验证码是否正确，如不正确，则不做接下来的操作
		request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		String session_yzm = (String) session.getAttribute("yzm");
		session_yzm.getBytes("UTF-8");
		System.out.println(session_yzm);
		
		if(session_yzm.equals(yzm)) {
			System.out.println("same");
			QueryRunner qr=new QueryRunner(C3P0_pool_Function.getDataSource());
			
			try {
				qr.update(sql, params);
				// 使用重定向到跳转页面
				response.setStatus(302);
				response.setHeader("location","/WEB13/success.html");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			response.getWriter().write("yzm error");
		}
		// 每次识别完验证码后都要删除此session
		try {
			session.removeAttribute("yzm");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
