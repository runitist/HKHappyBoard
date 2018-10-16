package kr.co.hkitedu.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.hkitedu.model.DAO.DAO_OracleQuery;
import kr.co.hkitedu.model.DTO.BoardVO;
import kr.co.hkitedu.model.DTO.TempSectionPageStat;

@WebServlet("/BoardServlet")
public class BoardServlet extends HttpServlet {
	// 게시판 뷰단으로 이동하는 컨트롤러
	// 페이지 정보 + 게시판 종류 + 게시판 정보 객체 필요.
	private static final long serialVersionUID = 1L;

	public BoardServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("보드 서블릿 진입 완료");
		String wb = "1";// 무슨 보드인가?
		TempSectionPageStat tsps = new TempSectionPageStat();// 템플릿으로 넘겨줄 페이지 자료
		String wbq = "h_board1";// 쿼리문으로 넘겨줄 보드명
		String wbp = "1";// 보드 페이지. 기본값은 1.
		final int PGMAX = 20;// 페이지 최대 로우개수
		ArrayList<BoardVO> bvl = null;
		int ctr = 1;// 해당 보드 전체 로우수
		int pgn = 2;// 페이지 수

		if (request.getParameter("wb") != null) {
			wb = request.getParameter("wb");
		} // wb 요청을 받음.

		if (wb.equals("1")) {
			tsps.setWps("Board");
			tsps.setWpsn("유머 게시판");
			wbq = "h_board1";
		} else if (wb.equals("2")) {
			tsps.setWps("Board");
			tsps.setWpsn("학습 게시판");
			wbq = "h_board2";
		} else if (wb.equals("3")) {
			tsps.setWps("Board");
			tsps.setWpsn("자유 게시판");
			wbq = "h_board3";
		}
		ctr = DAO_OracleQuery.getCountAllRows(wbq);
		pgn = (int)Math.ceil(((double)ctr)/PGMAX);
		
		if(request.getParameter("wbp") != null) {
			wbp = request.getParameter("wbp");
		}
		
		bvl = DAO_OracleQuery.getBvl(wbq);
		
		request.setAttribute("bvl", bvl);
		request.setAttribute("tsps", tsps);
		request.setAttribute("pgn", pgn);
		request.setAttribute("wb", wb);

		RequestDispatcher rd = request.getRequestDispatcher("VIEW/Template/Template.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
