package com.cn.hnust.pojo;

public class CountryPhoto {
    @Override
	public String toString() {
		return "CountryPhoto [idcountryphoto=" + idcountryphoto + ", src=" + src + ", countryId=" + countryId
				+ ", name=" + name + "]";
	}

	private Integer idcountryphoto;

    private String src;

    private Integer countryId;

    private String name;

    public Integer getIdcountryphoto() {
        return idcountryphoto;
    }

    public void setIdcountryphoto(Integer idcountryphoto) {
        this.idcountryphoto = idcountryphoto;
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
}