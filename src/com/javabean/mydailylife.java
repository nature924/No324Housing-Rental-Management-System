package com.javabean;

public class mydailylife {
    private Integer mdlid;

    private String mdldate;

    private String mdlcontent;

    public Integer getMdlid() {
        return mdlid;
    }

    public void setMdlid(Integer mdlid) {
        this.mdlid = mdlid;
    }

    public String getMdldate() {
        return mdldate;
    }

    public void setMdldate(String mdldate) {
        this.mdldate = mdldate == null ? null : mdldate.trim();
    }

    public String getMdlcontent() {
        return mdlcontent;
    }

    public void setMdlcontent(String mdlcontent) {
        this.mdlcontent = mdlcontent == null ? null : mdlcontent.trim();
    }
}