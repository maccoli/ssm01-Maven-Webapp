package com.cn.hnust.pojo;

public class Specialty {

	private Integer idspecialty;
	private String name;
	private String src;
	private Integer countryid;
	private String SPdescribe;//√Ë ˆ
	@Override
	public String toString() {
		return "Specialty [idspecialty=" + idspecialty + ", name=" + name
				+ ", src=" + src + ", countryid=" + countryid + ", SPdescribe="
				+ SPdescribe + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	public Integer getIdspecialty() {
		return idspecialty;
	}
	public void setIdspecialty(Integer idspecialty) {
		this.idspecialty = idspecialty;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public Integer getCountryid() {
		return countryid;
	}
	public void setCountryid(Integer countryid) {
		this.countryid = countryid;
	}
	public String getSPdescribe() {
		return SPdescribe;
	}
	public void setSPdescribe(String sPdescribe) {
		SPdescribe = sPdescribe;
	}
	
	
}
