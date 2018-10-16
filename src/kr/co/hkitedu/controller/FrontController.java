package kr.co.hkitedu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hkitedu.model.DAO.DAO_OracleQuery;
import kr.co.hkitedu.model.DAO.DBConnector;
import kr.co.hkitedu.model.DTO.TempSectionPageStat;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	// .do로 오는 모든 요청을 받아 각 서블릿으로 나눠주는 클래스
	private static final long serialVersionUID = 1L;

	public FrontController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String reqURI = request.getRequestURI().toString();//요청으로 들어온 URI를 가져옴.
		System.out.println(reqURI);//ex : /HKHappyBoard/Home.do
		String ctxPath = request.getContextPath();//요청으로 들어온 패키지 경로.
		System.out.println(ctxPath);//ex : /HKHappyBoard
		String ServletID = reqURI.substring(ctxPath.length() + 1);//URI에서 경로를 뺌.
		System.out.println(ServletID);// ex : Home.do
		RequestDispatcher rd;
		DBConnector.getConn();
		
		//여기서부터 아래로, 주소창으로 들어온 요청을 받아들여 각자 서블릿으로 분류함.
		if (ServletID.equals("Home.do")) {
			rd = request.getRequestDispatcher("HomeServlet");
			rd.forward(request, response);
		} else if (ServletID.equals("Board.do")) {
			rd = request.getRequestDispatcher("BoardServlet");
			rd.forward(request, response);
		} else if (ServletID.equals("Login.do")) {
			rd = request.getRequestDispatcher("LoginServlet");
			rd.forward(request, response);
		} else if (ServletID.equals("Signup.do")) {
			rd = request.getRequestDispatcher("SignupServlet");
			rd.forward(request, response);
		}
		//위와 같은 형태로 새로운 페이지마다 추가를 하면 됨.
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//post방식으로 들어온 요청을 인코딩
		doGet(request, response);//post방식으로 들어온 요청도 get으로 올려줌.
	}

}
