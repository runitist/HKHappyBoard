package kr.co.hkitedu.model.DTO;

public class UserVO {
	private int ubid;//회원 번호
	private String buser;//회원 아이디
	private String bpw;//회원 비밀번호
	private int ulevel;//회원 등급(0: 관리자)
	
	public int getUbid() {
		return ubid;
	}
	public void setUbid(int ubid) {
		this.ubid = ubid;
	}
	public String getBuser() {
		return buser;
	}
	public void setBuser(String buser) {
		this.buser = buser;
	}
	public String getBpw() {
		return bpw;
	}
	public void setBpw(String bpw) {
		this.bpw = bpw;
	}
	public int getUlevel() {
		return ulevel;
	}
	public void setUlevel(int ulevel) {
		this.ulevel = ulevel;
	}

}
