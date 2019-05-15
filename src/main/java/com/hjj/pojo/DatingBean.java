package com.hjj.pojo;

public class DatingBean {
	private int datingId;
	private String datingSponsorName;
	private String datingSponsorEmail;
	private String datingName;
	private String datingContent;
	private String datingStartTime;
	private String datingOverTime;
	private int datingSumpeople;
	private String datingCreatetime;
	public int getDatingId() {
		return datingId;
	}
	public void setDatingId(int datingId) {
		this.datingId = datingId;
	}
	public String getDatingSponsorName() {
		return datingSponsorName;
	}
	public void setDatingSponsorName(String datingSponsorName) {
		this.datingSponsorName = datingSponsorName;
	}
	public String getDatingSponsorEmail() {
		return datingSponsorEmail;
	}
	public void setDatingSponsorEmail(String datingSponsorEmail) {
		this.datingSponsorEmail = datingSponsorEmail;
	}
	public String getDatingName() {
		return datingName;
	}
	public void setDatingName(String datingName) {
		this.datingName = datingName;
	}
	public String getDatingContent() {
		return datingContent;
	}
	public void setDatingContent(String datingContent) {
		this.datingContent = datingContent;
	}
	public String getDatingStartTime() {
		return datingStartTime;
	}
	public void setDatingStartTime(String datingStartTime) {
		this.datingStartTime = datingStartTime;
	}
	public String getDatingOverTime() {
		return datingOverTime;
	}
	public void setDatingOverTime(String datingOverTime) {
		this.datingOverTime = datingOverTime;
	}
	public int getDatingSumpeople() {
		return datingSumpeople;
	}
	public void setDatingSumpeople(int datingSumpeople) {
		this.datingSumpeople = datingSumpeople;
	}
	public String getDatingCreatetime() {
		return datingCreatetime;
	}
	public void setDatingCreatetime(String datingCreatetime) {
		this.datingCreatetime = datingCreatetime;
	}
	@Override
	public String toString() {
		return "DatingBean [datingId=" + datingId + ", datingSponsorName=" + datingSponsorName
				+ ", datingSponsorEmail=" + datingSponsorEmail + ", datingName=" + datingName + ", datingContent="
				+ datingContent + ", datingStartTime=" + datingStartTime + ", datingOverTime=" + datingOverTime
				+ ", datingSumpeople=" + datingSumpeople + ", datingCreatetime=" + datingCreatetime + "]";
	}
	

}
