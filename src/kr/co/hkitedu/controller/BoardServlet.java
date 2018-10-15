package kr.co.hkitedu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hkitedu.model.DTO.TempSectionPageStat;

@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TempSectionPageStat tsps = new TempSectionPageStat();
		String wb = request.getParameter("wb");

		tsps.setWps("Board");
		if (wb.equals("1")) {
			tsps.setWpsn("유머 게시판");
		} else if (wb.equals("2")) {
			tsps.setWpsn("학습 게시판");
		} else if (wb.equals("3")) {
			tsps.setWpsn("자유 게시판");
		}

		request.setAttribute("tsps", tsps);

		RequestDispatcher rd = request.getRequestDispatcher("VIEW/Template/Template.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
