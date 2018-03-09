package com.cn.hnust.pojo;

import java.util.Date;

public class Sysday {
    private Integer idsysinfo;

    private Integer sumreg;

    private Integer sumlog;

    private Integer sumbrowse;

    private Date date;

    public Integer getIdsysinfo() {
        return idsysinfo;
    }

    public void setIdsysinfo(Integer idsysinfo) {
        this.idsysinfo = idsysinfo;
    }

    public Integer getSumreg() {
        return sumreg;
    }

    public void setSumreg(Integer sumreg) {
        this.sumreg = sumreg;
    }

    public Integer getSumlog() {
        return sumlog;
    }

    public void setSumlog(Integer sumlog) {
        this.sumlog = sumlog;
    }

    public Integer getSumbrowse() {
        return sumbrowse;
    }

    public void setSumbrowse(Integer sumbrowse) {
        this.sumbrowse = sumbrowse;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}