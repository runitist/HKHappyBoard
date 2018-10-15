package kr.co.hkitedu.model.DTO;

public class TempSectionPageStat {
	// 템플릿 섹션 부분에 무엇이 올것인지에 대한 정보를 관리하는 클래스
	private String wps = ""; // 템플릿 섹션의 페이지
	private String wpsn = ""; // 템플릿 섹션의 이름.

	public String getWps() {
		return wps;
	}

	public void setWps(String wps) {
		this.wps = wps;
	}

	public String getWpsn() {
		return wpsn;
	}

	public void setWpsn(String wpsn) {
		this.wpsn = wpsn;
	}

}
