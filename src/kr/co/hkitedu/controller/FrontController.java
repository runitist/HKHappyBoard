package kr.co.hkitedu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hkitedu.model.DTO.TempSectionPageStat;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String reqURI = request.getRequestURI().toString();
		System.out.println(reqURI);
		String ctxPath = request.getContextPath();
		System.out.println(ctxPath);
		String ServletID = reqURI.substring(ctxPath.length() + 1);
		System.out.println(ServletID);
		RequestDispatcher rd;

		if (ServletID.equals("Home.do")) {
			rd = request.getRequestDispatcher("HomeServlet");
			rd.forward(request, response);
		} else if (ServletID.equals("Board.do")) {
			rd = request.getRequestDispatcher("BoardServlet");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
