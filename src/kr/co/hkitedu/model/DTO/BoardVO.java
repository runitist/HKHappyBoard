package kr.co.hkitedu.model.DTO;

public class BoardVO {
	// 게시판 페이지에 필요한 Board의 DB정보를 관리하는 클래스
	private int bid;// 게시번호
	private String btitle;// 게시글 제목
	private String bcontent;// 게시글 내용
	private String bregdate;// 게시일
	private String bupdate;// 최근 업데이트일
	private String pw;// 비밀번호
	private String buser;// 게시자

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getBregdate() {
		return bregdate;
	}

	public void setBregdate(String bregdate) {
		this.bregdate = bregdate;
	}

	public String getBupdate() {
		return bupdate;
	}

	public void setBupdate(String bupdate) {
		this.bupdate = bupdate;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getBuser() {
		return buser;
	}

	public void setBuser(String buser) {
		this.buser = buser;
	}

}
