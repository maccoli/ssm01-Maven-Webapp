package com.cn.hnust.pojo;

import java.util.Date;

public class CountrysideColl {
    private Integer idcountrysidecoll;

    private Date colltime;

    private String remark;

    private Integer userUserid;

    private Integer countryId;

    private String mainpic;

    private String countrysideName;

    public Integer getIdcountrysidecoll() {
        return idcountrysidecoll;
    }

    public void setIdcountrysidecoll(Integer idcountrysidecoll) {
        this.idcountrysidecoll = idcountrysidecoll;
    }

    public Date getColltime() {
        return colltime;
    }

    public void setColltime(Date colltime) {
        this.colltime = colltime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getUserUserid() {
        return userUserid;
    }

    public void setUserUserid(Integer userUserid) {
        this.userUserid = userUserid;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getMainpic() {
        return mainpic;
    }

    public void setMainpic(String mainpic) {
        this.mainpic = mainpic == null ? null : mainpic.trim();
    }

    public String getCountrysideName() {
        return countrysideName;
    }

    @Override
	public String toString() {
		return "CountrysideColl [idcountrysidecoll=" + idcountrysidecoll + ", colltime=" + colltime + ", remark="
				+ remark + ", userUserid=" + userUserid + ", countryId=" + countryId + ", mainpic=" + mainpic
				+ ", countrysideName=" + countrysideName + "]";
	}

	public void setCountrysideName(String countrysideName) {
        this.countrysideName = countrysideName == null ? null : countrysideName.trim();
    }
}