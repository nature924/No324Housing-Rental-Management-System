package com.javabean;

public class rentwithdrawn {
    private Integer rwid;

    private String rwusername;

    private String rwuserid;

    private String rwuserphone;

    private String rwhouseid;

    private String rwhouseaddress;

    private Double rwhouseprice;

    private String rwstate;
    
    private String state1;
    
    private String state2;
    
	public String getState1() {
		return state1;
	}

	public void setState1(String state1) {
		this.state1 = state1;
	}

	public String getState2() {
		return state2;
	}

	public void setState2(String state2) {
		this.state2 = state2;
	}

	public Integer getRwid() {
        return rwid;
    }

    public void setRwid(Integer rwid) {
        this.rwid = rwid;
    }

    public String getRwusername() {
        return rwusername;
    }

    public void setRwusername(String rwusername) {
        this.rwusername = rwusername == null ? null : rwusername.trim();
    }

    public String getRwuserid() {
        return rwuserid;
    }

    public void setRwuserid(String rwuserid) {
        this.rwuserid = rwuserid == null ? null : rwuserid.trim();
    }

    public String getRwuserphone() {
        return rwuserphone;
    }

    public void setRwuserphone(String rwuserphone) {
        this.rwuserphone = rwuserphone == null ? null : rwuserphone.trim();
    }

    public String getRwhouseid() {
        return rwhouseid;
    }

    public void setRwhouseid(String rwhouseid) {
        this.rwhouseid = rwhouseid == null ? null : rwhouseid.trim();
    }

    public String getRwhouseaddress() {
        return rwhouseaddress;
    }

    public void setRwhouseaddress(String rwhouseaddress) {
        this.rwhouseaddress = rwhouseaddress == null ? null : rwhouseaddress.trim();
    }

    public Double getRwhouseprice() {
        return rwhouseprice;
    }

    public void setRwhouseprice(Double rwhouseprice) {
        this.rwhouseprice = rwhouseprice;
    }

    public String getRwstate() {
        return rwstate;
    }

    public void setRwstate(String rwstate) {
        this.rwstate = rwstate == null ? null : rwstate.trim();
    }
}