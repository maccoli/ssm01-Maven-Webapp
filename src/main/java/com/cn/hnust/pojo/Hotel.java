package com.cn.hnust.pojo;

public class Hotel {
    private Integer idhotel;

    @Override
	public String toString() {
		return "Hotel [idhotel=" + idhotel + ", hotelname=" + hotelname + ", score=" + score + ", mainpic=" + mainpic
				+ ", lowprice=" + lowprice + ", location=" + location + ", phone=" + phone + ", video=" + video
				+ ", detaillocation=" + detaillocation + ", passengersum=" + passengersum + ", countryId=" + countryId
				+ ", addtime=" + addtime + ", pice=" + pice + ", examine=" + examine + ", userid=" + userid
				+ ", username=" + username + ", introduce=" + introduce + "]";
	}

	private String hotelname;

    private Double score;

    private String mainpic;

    private Double lowprice;

    private String location;

    private String phone;

    private String video;

    private String detaillocation;

    private Integer passengersum;

    private Integer countryId;

    private String addtime;

    private String pice;

    private Integer examine;

    private Integer userid;

    private String username;

    private String introduce;

    public Integer getIdhotel() {
        return idhotel;
    }

    public void setIdhotel(Integer idhotel) {
        this.idhotel = idhotel;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname == null ? null : hotelname.trim();
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getMainpic() {
        return mainpic;
    }

    public void setMainpic(String mainpic) {
        this.mainpic = mainpic == null ? null : mainpic.trim();
    }

    public Double getLowprice() {
        return lowprice;
    }

    public void setLowprice(Double lowprice) {
        this.lowprice = lowprice;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video == null ? null : video.trim();
    }

    public String getDetaillocation() {
        return detaillocation;
    }

    public void setDetaillocation(String detaillocation) {
        this.detaillocation = detaillocation == null ? null : detaillocation.trim();
    }

    public Integer getPassengersum() {
        return passengersum;
    }

    public void setPassengersum(Integer passengersum) {
        this.passengersum = passengersum;
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

    public String getPice() {
        return pice;
    }

    public void setPice(String pice) {
        this.pice = pice == null ? null : pice.trim();
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

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }
}