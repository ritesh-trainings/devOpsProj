package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class calcSumServlet
 */
@WebServlet("/CalcSumServlet")
public class CalcSumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalcSumServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// getting params
		double num1 = Double.NaN, num2 = Double.NaN;
		String result = null, err = null;
		try {
			num1 = Double.parseDouble(request.getParameter("value1"));
		} catch (Exception e) {
			result = "Error";
			err = "Please Enter Number 1 Correctly";
		}
		try {
			num2 = Double.parseDouble(request.getParameter("value2"));
		} catch (Exception e) {
			result = "Error";
			err = "Please Enter Number 2 Correctly";
		}
		if (!"Error".equals(result))
			result = String.valueOf(num1 + num2);
		response.getWriter().append(result);
		RequestDispatcher rd = request.getRequestDispatcher("");
		request.setAttribute("result", result);
		request.setAttribute("err", err);
		rd.forward(request, response);
	}

}
