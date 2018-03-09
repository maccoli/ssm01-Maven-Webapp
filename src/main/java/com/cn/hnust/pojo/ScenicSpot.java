package com.cn.hnust.pojo;

public class ScenicSpot {
    private Integer scenicspotid;

    private String name;

    private String location;

    private Integer price;

    private String cinformation;

    private String address;

    private String cover;

    private String pices;

    private String video;

    private Integer countryId;

    private String addtime;

    private Integer examine;

    private Integer userid;

    private String username;

    private String tag1;

    private String tag2;

    private String synosis;

    public Integer getScenicspotid() {
        return scenicspotid;
    }

    public void setScenicspotid(Integer scenicspotid) {
        this.scenicspotid = scenicspotid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCinformation() {
        return cinformation;
    }

    public void setCinformation(String cinformation) {
        this.cinformation = cinformation == null ? null : cinformation.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover == null ? null : cover.trim();
    }

    public String getPices() {
        return pices;
    }

    public void setPices(String pices) {
        this.pices = pices == null ? null : pices.trim();
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video == null ? null : video.trim();
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime == null ? null : addtime.trim();
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

    public String getTag1() {
        return tag1;
    }

    public void setTag1(String tag1) {
        this.tag1 = tag1 == null ? null : tag1.trim();
    }

    public String getTag2() {
        return tag2;
    }

    public void setTag2(String tag2) {
        this.tag2 = tag2 == null ? null : tag2.trim();
    }

    public String getSynosis() {
        return synosis;
    }

    public void setSynosis(String synosis) {
        this.synosis = synosis == null ? null : synosis.trim();
    }

	@Override
	public String toString() {
		return "ScenicSpot [scenicspotid=" + scenicspotid + ", name=" + name + ", location=" + location + ", price="
				+ price + ", cinformation=" + cinformation + ", address=" + address + ", cover=" + cover + ", pices="
				+ pices + ", video=" + video + ", countryId=" + countryId + ", addtime=" + addtime + ", examine="
				+ examine + ", userid=" + userid + ", username=" + username + ", tag1=" + tag1 + ", tag2=" + tag2
				+ ", synosis=" + synosis + "]";
	}
}