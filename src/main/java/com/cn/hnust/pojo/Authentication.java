package com.cn.hnust.pojo;

public class Authentication {

	private Integer id;
	private Integer userid; //�û�ID
	private String realname;//��ʵ����
	private String realid;//���id
	private String idcardo;//���֤����
	private String idcardx;//���֤����
	private String remarks;//��ע
	private String remarkphoto;//��ע��Ƭ

	@Override
	public String toString() {
		return "Authentication [id=" + id + ", userid=" + userid
				+ ", realname=" + realname + ", realid=" + realid
				+ ", idcardo=" + idcardo + ", idcardx=" + idcardx
				+ ", remarks=" + remarks + ", remarkphoto=" + remarkphoto + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getRealid() {
		return realid;
	}
	public void setRealid(String realid) {
		this.realid = realid;
	}
	public String getIdcardo() {
		return idcardo;
	}
	public void setIdcardo(String idcardo) {
		this.idcardo = idcardo;
	}
	public String getIdcardx() {
		return idcardx;
	}
	public void setIdcardx(String idcardx) {
		this.idcardx = idcardx;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getRemarkphoto() {
		return remarkphoto;
	}
	public void setRemarkphoto(String remarkphoto) {
		this.remarkphoto = remarkphoto;
	}
	
}
