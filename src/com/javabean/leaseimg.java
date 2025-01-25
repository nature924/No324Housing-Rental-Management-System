package com.javabean;

public class leaseimg {
    private Integer id;

    private String imgname;

    private String imgroute;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImgname() {
        return imgname;
    }

    public void setImgname(String imgname) {
        this.imgname = imgname == null ? null : imgname.trim();
    }

    public String getImgroute() {
        return imgroute;
    }

    public void setImgroute(String imgroute) {
        this.imgroute = imgroute == null ? null : imgroute.trim();
    }
}