package com.javabean;

public class checkoutapplication {
    private Integer coaid;

    private String coausername;

    private String coauserid;

    private String coauserphone;

    private String coahouseaddress;

    private Double coahouseprice;

    private String coastate;

    private String coahouseid;
    
    private String state1;
    
    private String state2;
    
    private String state3;
    
    private Double coahousesize;
    
    public Double getCoahousesize() {
		return coahousesize;
	}

	public void setCoahousesize(Double coahousesize) {
		this.coahousesize = coahousesize;
	}

	public String getState3() {
		return state3;
	}

	public void setState3(String state3) {
		this.state3 = state3;
	}

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

	public String getCoahouseid() {
		return coahouseid;
	}

	public void setCoahouseid(String coahouseid) {
		this.coahouseid = coahouseid;
	}

	public Integer getCoaid() {
        return coaid;
    }

    public void setCoaid(Integer coaid) {
        this.coaid = coaid;
    }

    public String getCoausername() {
        return coausername;
    }

    public void setCoausername(String coausername) {
        this.coausername = coausername == null ? null : coausername.trim();
    }

    public String getCoauserid() {
        return coauserid;
    }

    public void setCoauserid(String coauserid) {
        this.coauserid = coauserid == null ? null : coauserid.trim();
    }

    public String getCoauserphone() {
        return coauserphone;
    }

    public void setCoauserphone(String coauserphone) {
        this.coauserphone = coauserphone == null ? null : coauserphone.trim();
    }

    public String getCoahouseaddress() {
        return coahouseaddress;
    }

    public void setCoahouseaddress(String coahouseaddress) {
        this.coahouseaddress = coahouseaddress == null ? null : coahouseaddress.trim();
    }

    public Double getCoahouseprice() {
        return coahouseprice;
    }

    public void setCoahouseprice(Double coahouseprice) {
        this.coahouseprice = coahouseprice;
    }

    public String getCoastate() {
        return coastate;
    }

    public void setCoastate(String coastate) {
        this.coastate = coastate == null ? null : coastate.trim();
    }
}