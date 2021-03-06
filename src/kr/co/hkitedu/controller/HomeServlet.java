package kr.co.hkitedu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hkitedu.model.DTO.TempSectionPageStat;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	// Home 페이지로 이동하는 컨트롤러.
	private static final long serialVersionUID = 1L;

	public HomeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TempSectionPageStat tsps = new TempSectionPageStat();// 템플릿 페이지 변환에 필요한 정보를 담은 객체
		// 해당 서블릿으로 요청이 들어오면 페이지 스텟 객체의 값을 변환 시켜준다.
		tsps.setWps("Home");
		tsps.setWpsn("Happy Board");
		// 앞으로 위와 같이 기재하면 템플릿 정보가 변한다.
		request.setAttribute("tsps", tsps);// 위에서 세팅된 정보 객체를 request의 attribute에 올려준다.
		//해당 페이지에 필요한 정보는 모두 attribute에 세팅하면 된다.

		// 아래로는 어느 서블릿이나 동일하다.
		// 중요한 것은 attribute만 잘 설정하면 템플릿 페이지의 변환이 일어난다.
		RequestDispatcher rd = request.getRequestDispatcher("VIEW/Template/Template.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
