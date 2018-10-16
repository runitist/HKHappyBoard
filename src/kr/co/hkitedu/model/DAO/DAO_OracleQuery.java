package kr.co.hkitedu.model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import kr.co.hkitedu.model.DTO.BoardVO;

public class DAO_OracleQuery {
	// DB의 정보를 변경, 입력, 추출하는 클래스.

	public static void CloseResource(ResultSet rs, PreparedStatement ps, Connection conn) {
		// 사용한 리소스를 해지하는 메소드
		try {
			if (rs != null)
				rs.close();
			System.out.println("rs클로즈");
		} catch (Exception e) {
		}
		try {
			if (ps != null)
				ps.close();
			System.out.println("ps클로즈");
		} catch (Exception e) {
		}
		try {
			if (conn != null)
				conn.close();
			System.out.println("conn클로즈");
		} catch (Exception e) {
		}
	}

	public static void CloseResource(PreparedStatement ps, Connection conn) {
		// 사용한 리소스를 해지하는 메소드 오버로딩
		try {
			if (ps != null)
				ps.close();
			System.out.println("ps클로즈");
		} catch (Exception e) {
		}
		try {
			if (conn != null)
				conn.close();
			System.out.println("conn클로즈");
		} catch (Exception e) {
		}
	}

	public static int getCountAllRows(String wbq) {
		int countAll = 0;
		Connection conn = DBConnector.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "select count(*) as ca from " + wbq;
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				countAll = rs.getInt("ca");
			}

		} catch (Exception e) {
			System.out.println("최대 로우개수 카운트 오류");
		} finally {
			CloseResource(rs, ps, conn);
		}

		return countAll;
	}

	public static ArrayList<BoardVO> getBvl(String wbq, String wbp, int PGMAX) {
		// DB정보를 가져오는 리스트를 작성
		// wbp는 해당 페이지의 보드 페이지값.
		// PGMAX는 한 페이지당 보드 로우의 최대개수
		ArrayList<BoardVO> bvl = new ArrayList<BoardVO>();
		Connection conn = DBConnector.getConn();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String sql = "select * from(select * from " + wbq + 
					" order by bid) where rownum <= " + PGMAX;

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				BoardVO bv = new BoardVO();
				bv.setBid(rs.getInt("bid"));
				bv.setBtitle(rs.getString("btitle"));
				bv.setBcontent(rs.getString("bcontent"));
				bv.setBregdate(rs.getString("bregdate"));
				bv.setBupdate(rs.getString("bupdate"));
				bv.setBuser(rs.getString("pw"));
				bv.setBuser(rs.getString("buser"));
				bvl.add(bv);
			}

			System.out.println("리스트화 성공");
		} catch (Exception e) {
			System.out.println("리스트화 실패");
			e.printStackTrace();
		} finally {
			CloseResource(rs, ps, conn);
		}

		return bvl;
	}

}
