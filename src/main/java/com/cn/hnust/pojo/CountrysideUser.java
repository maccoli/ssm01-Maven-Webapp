package com.cn.hnust.pojo;

public class CountrysideUser {
    private Integer idcountrysideuser;

    private String useremail;

    private String userpassword;

    private String headpic;

    @Override
	public String toString() {
		return "CountrysideUser [idcountrysideuser=" + idcountrysideuser + ", useremail=" + useremail
				+ ", userpassword=" + userpassword + ", headpic=" + headpic + ", name=" + name + ", idcard=" + idcard
				+ ", countrysideId=" + countrysideId + ", userphone=" + userphone + ", sex=" + sex + ", city=" + city
				+ "]";
	}

	private String name;

    private String idcard;

    private String countrysideId;

    private String userphone;

    private String sex;

    private String city;

    public Integer getIdcountrysideuser() {
        return idcountrysideuser;
    }

    public void setIdcountrysideuser(Integer idcountrysideuser) {
        this.idcountrysideuser = idcountrysideuser;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail == null ? null : useremail.trim();
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword == null ? null : userpassword.trim();
    }

    public String getHeadpic() {
        return headpic;
    }

    public void setHeadpic(String headpic) {
        this.headpic = headpic == null ? null : headpic.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getCountrysideId() {
        return countrysideId;
    }

    public void setCountrysideId(String countrysideId) {
        this.countrysideId = countrysideId == null ? null : countrysideId.trim();
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone == null ? null : userphone.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }
}