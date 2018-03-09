package com.cn.hnust.pojo;

import java.sql.Time;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class User {
    @Override
	public String toString() {
		return "User [userid=" + userid + ", useremail=" + useremail + ", userpassword=" + userpassword + ", level="
				+ level + ", fans=" + fans + ", experience=" + experience + ", headpic=" + headpic + ", sex=" + sex
				+ ", birth=" + birth + ", signature=" + signature + ", attention=" + attention + ", city=" + city
				+ ", phone=" + phone + ", wechat=" + wechat + ", favorite=" + favorite + ", articles=" + articles
				+ ", routes=" + routes + ", username=" + username + ", keyval=" + keyval + ", active=" + active
				+ ", alltime=" + alltime + ", lasttime=" + lasttime + "]";
	}

	private Integer userid;

    private String useremail;

    private String userpassword;

    private Integer level;

    private Integer fans;

    private Integer experience;

    private String headpic;

    private String sex;

    private Date birth;

    private String signature;

    private Integer attention;

    private String city;

    private String phone;

    private String wechat;

    private String favorite;

    private Integer articles;

    private Integer routes;

    private String username;

    private String keyval;

    private Byte active;

	@DateTimeFormat(pattern = "yy-mm-dd")
	private Time alltime;

    private Date lasttime;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getFans() {
        return fans;
    }

    public void setFans(Integer fans) {
        this.fans = fans;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getHeadpic() {
        return headpic;
    }

    public void setHeadpic(String headpic) {
        this.headpic = headpic == null ? null : headpic.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature == null ? null : signature.trim();
    }

    public Integer getAttention() {
        return attention;
    }

    public void setAttention(Integer attention) {
        this.attention = attention;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite == null ? null : favorite.trim();
    }

    public Integer getArticles() {
        return articles;
    }

    public void setArticles(Integer articles) {
        this.articles = articles;
    }

    public Integer getRoutes() {
        return routes;
    }

    public void setRoutes(Integer routes) {
        this.routes = routes;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getKeyval() {
        return keyval;
    }

    public void setKeyval(String keyval) {
        this.keyval = keyval == null ? null : keyval.trim();
    }

    public Byte getActive() {
        return active;
    }

    public void setActive(Byte active) {
        this.active = active;
    }

    public Date getAlltime() {
        return alltime;
    }

    public void setAlltime(Time alltime) {
        this.alltime = alltime;
    }

    public Date getLasttime() {
        return lasttime;
    }

    public void setLasttime(Date lasttime) {
        this.lasttime = lasttime;
    }
}