package com.cn.hnust.pojo;

import java.util.Date;

public class Article {
    private Integer idarticle;

    private String name;

    private String username;

    private Date articletime;

    private String mainpic;

    private Integer stars;

    private String location;

    private Integer userUserid;

    private String content;

    public Integer getIdarticle() {
        return idarticle;
    }

    public void setIdarticle(Integer idarticle) {
        this.idarticle = idarticle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getArticletime() {
        return articletime;
    }

    public void setArticletime(Date articletime) {
        this.articletime = articletime;
    }

    public String getMainpic() {
        return mainpic;
    }

    public void setMainpic(String mainpic) {
        this.mainpic = mainpic == null ? null : mainpic.trim();
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
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

    public Article(String name, String username, Date articletime, String mainpic, String location, Integer userUserid,
			String content) {
		super();
		this.name = name;
		this.username = username;
		this.articletime = articletime;
		this.mainpic = mainpic;
		this.location = location;
		this.userUserid = userUserid;
		this.content = content;
	}

	public Article() {
		super();
	}

	@Override
	public String toString() {
		return "Article [idarticle=" + idarticle + ", name=" + name + ", username=" + username + ", articletime="
				+ articletime + ", mainpic=" + mainpic + ", stars=" + stars + ", location=" + location + ", userUserid="
				+ userUserid + ", content=" + content + "]";
	}

	public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}