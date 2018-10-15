package kr.co.hkitedu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hkitedu.model.DTO.TempSectionPageStat;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	//회원가입 페이지로 이동하는 컨트롤러.
	private static final long serialVersionUID = 1L;
    public SignupServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TempSectionPageStat tsps = new TempSectionPageStat();
		tsps.setWps("Signup");
		tsps.setWpsn("회원가입");
		request.setAttribute("tsps", tsps);

		RequestDispatcher rd = request.getRequestDispatcher("VIEW/Template/Template.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
