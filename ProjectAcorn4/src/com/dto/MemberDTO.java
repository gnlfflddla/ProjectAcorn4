package com.dto;

public class MemberDTO {
	private String userid;
	private String passwd;
	private String username;
	private String birthday;
	private String post;
	private String addr1;
	private String addr2;
	private String phone;
	private String email;
	private String gradeno;
	private String reception;
	public MemberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberDTO(String userid, String passwd, String username, String birthday, String post, String addr1,
			String addr2, String phone, String email, String gradeno, String reception) {
		super();
		this.userid = userid;
		this.passwd = passwd;
		this.username = username;
		this.birthday = birthday;
		this.post = post;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.phone = phone;
		this.email = email;
		this.gradeno = gradeno;
		this.reception = reception;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getAddr1() {
		return addr1;
	}
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	public String getAddr2() {
		return addr2;
	}
	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGradeno() {
		return gradeno;
	}
	public void setGradeno(String gradeno) {
		this.gradeno = gradeno;
	}
	public String getReception() {
		return reception;
	}
	public void setReception(String reception) {
		this.reception = reception;
	}
	@Override
	public String toString() {
		return "MemberDTO [userid=" + userid + ", passwd=" + passwd + ", username=" + username + ", birthday="
				+ birthday + ", post=" + post + ", addr1=" + addr1 + ", addr2=" + addr2 + ", phone=" + phone
				+ ", email=" + email + ", gradeno=" + gradeno + ", reception=" + reception + "]";
	}
	
	
	

	}