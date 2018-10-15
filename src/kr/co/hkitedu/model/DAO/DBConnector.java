package kr.co.hkitedu.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	// 데이터베이스 접속 커넥션을 관리하는 클래스

	public static Connection getConn() {
		// DB커넥션을 반환하는 메서드. 이후 커넥션풀로 변경예정.
		Connection conn = null;
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hkitedu";

		try {
			Class.forName(driver);
			System.out.println("DB드라이버 연결 성공");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("DB 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("DB드라이버 연결 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
			e.printStackTrace();
		}
		return conn;
	}

}
