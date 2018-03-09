package com.cn.hnust.pojo;

public class CountryVideo {
    private Integer idcountryvideo;

    private String src;

    private Integer countryId;

    private String name;

    public Integer getIdcountryvideo() {
        return idcountryvideo;
    }

    public void setIdcountryvideo(Integer idcountryvideo) {
        this.idcountryvideo = idcountryvideo;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src == null ? null : src.trim();
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

	@Override
	public String toString() {
		return "CountryVideo [idcountryvideo=" + idcountryvideo + ", src=" + src + ", countryId=" + countryId
				+ ", name=" + name + "]";
	}
}