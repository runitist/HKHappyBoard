package kr.co.hkitedu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import kr.co.hkitedu.model.DTO.TempSectionPageStat;
import kr.co.hkitedu.model.DTO.UserVO;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	// 로그인 페이지로 이동하는 컨트롤러.
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TempSectionPageStat tsps = new TempSectionPageStat();
		if(request.getParameter("loginID") ==null) {
			tsps.setWps("Login");
			tsps.setWpsn("로그인");
			request.setAttribute("tsps", tsps);

			RequestDispatcher rd = request.getRequestDispatcher("VIEW/Template/Template.jsp");
			rd.forward(request, response);
		}else {
			String loginID = request.getParameter("loginID");
			String loginPW = request.getParameter("loginPW");
			
			if(true) {
				//TODO:아이디 조회 쿼리 작성
				if(true) {
					//TODO:아이디와 비밀번호 일치 조회 쿼리 작성.
					HttpSession session = request.getSession();
					//TODO:해당 아이디의 정보를 vo로 담는 쿼리 작성.
					UserVO userVO = new UserVO();
					session.setAttribute("loginID", loginID);
					session.setAttribute("loginPW", loginPW);
					System.out.println("로그인에 성공했습니다.");
					
					
				}else {
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
			}else {
				System.out.println("아이디가 없습니다.");
			}
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
