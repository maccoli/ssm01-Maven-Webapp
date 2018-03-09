package com.cn.hnust.pojo;

import java.util.Date;

public class CountryComment {
    private Integer idcountrycomment;

    private Double score;

    private Integer nicesum;

    private Integer badsum;

    private Date delivertime;

    private Integer countryId;

    private Integer userUserid;

    private String content;

    private String username;
    
    private String headpic;
    
    @Override
	public String toString() {
		return "CountryComment [idcountrycomment=" + idcountrycomment + ", score=" + score + ", nicesum=" + nicesum
				+ ", badsum=" + badsum + ", delivertime=" + delivertime + ", countryId=" + countryId + ", userUserid="
				+ userUserid + ", content=" + content + ", username=" + username + ", headpic=" + headpic + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getHeadpic() {
		return headpic;
	}

	public void setHeadpic(String headpic) {
		this.headpic = headpic;
	}

	public Integer getIdcountrycomment() {
        return idcountrycomment;
    }

    public void setIdcountrycomment(Integer idcountrycomment) {
        this.idcountrycomment = idcountrycomment;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getNicesum() {
        return nicesum;
    }

    public void setNicesum(Integer nicesum) {
        this.nicesum = nicesum;
    }

    public Integer getBadsum() {
        return badsum;
    }

    public void setBadsum(Integer badsum) {
        this.badsum = badsum;
    }

    public Date getDelivertime() {
        return delivertime;
    }

    public void setDelivertime(Date delivertime) {
        this.delivertime = delivertime;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getUserUserid() {
        return userUserid;
    }

    public void setUserUserid(Integer userUserid) {
        this.userUserid = userUserid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}