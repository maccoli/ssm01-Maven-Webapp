package com.cn.hnust.pojo;

import java.util.Date;

public class Country {
    private Integer id;

    private String name;

    private Integer sights;

    private String location;

    private String ac;

    private String rc;

    private String cc;

    private Integer targetsum;

    private Double score;

    private String mianpic;

    private Integer hotels;

    private Integer restaurants;

    private Integer examine;

    private Integer userid;

    private String username;

    private String countrytype;

    private Date addtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSights() {
        return sights;
    }

    public void setSights(Integer sights) {
        this.sights = sights;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getAc() {
        return ac;
    }

    public void setAc(String ac) {
        this.ac = ac == null ? null : ac.trim();
    }

    public String getRc() {
        return rc;
    }

    public void setRc(String rc) {
        this.rc = rc == null ? null : rc.trim();
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc == null ? null : cc.trim();
    }

    public Integer getTargetsum() {
        return targetsum;
    }

    public void setTargetsum(Integer targetsum) {
        this.targetsum = targetsum;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getMianpic() {
        return mianpic;
    }

    public void setMianpic(String mianpic) {
        this.mianpic = mianpic == null ? null : mianpic.trim();
    }

    public Integer getHotels() {
        return hotels;
    }

    public void setHotels(Integer hotels) {
        this.hotels = hotels;
    }

    public Integer getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Integer restaurants) {
        this.restaurants = restaurants;
    }

    public Integer getExamine() {
        return examine;
    }

    public void setExamine(Integer examine) {
        this.examine = examine;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getCountrytype() {
        return countrytype;
    }

    public void setCountrytype(String countrytype) {
        this.countrytype = countrytype == null ? null : countrytype.trim();
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", sights=" + sights + ", location=" + location + ", ac=" + ac
				+ ", rc=" + rc + ", cc=" + cc + ", targetsum=" + targetsum + ", score=" + score + ", mianpic=" + mianpic
				+ ", hotels=" + hotels + ", restaurants=" + restaurants + ", examine=" + examine + ", userid=" + userid
				+ ", username=" + username + ", countrytype=" + countrytype + ", addtime=" + addtime + "]";
	}
}