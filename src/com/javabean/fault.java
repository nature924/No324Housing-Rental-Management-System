package com.javabean;

import java.util.Date;

public class fault {
	private Integer fid;

	private String fhouseid;

	private String fhouseaddress;

	private Double fprice;

	private Date fdate;

	private String fdatetemp;

	private String fcontent;

	private String fusername;

	private String fuserid;

	private String fuserphone;

	private String fstate;

	public String getFdatetemp() {
		return fdatetemp;
	}

	public void setFdatetemp(String fdatetemp) {
		this.fdatetemp = fdatetemp;
	}

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getFhouseid() {
		return fhouseid;
	}

	public void setFhouseid(String fhouseid) {
		this.fhouseid = fhouseid == null ? null : fhouseid.trim();
	}

	public String getFhouseaddress() {
		return fhouseaddress;
	}

	public void setFhouseaddress(String fhouseaddress) {
		this.fhouseaddress = fhouseaddress == null ? null : fhouseaddress.trim();
	}

	public Double getFprice() {
		return fprice;
	}

	public void setFprice(Double fprice) {
		this.fprice = fprice;
	}

	public Date getFdate() {
		return fdate;
	}

	public void setFdate(Date fdate) {
		this.fdate = fdate;
	}

	public String getFcontent() {
		return fcontent;
	}

	public void setFcontent(String fcontent) {
		this.fcontent = fcontent == null ? null : fcontent.trim();
	}

	public String getFusername() {
		return fusername;
	}

	public void setFusername(String fusername) {
		this.fusername = fusername == null ? null : fusername.trim();
	}

	public String getFuserid() {
		return fuserid;
	}

	public void setFuserid(String fuserid) {
		this.fuserid = fuserid == null ? null : fuserid.trim();
	}

	public String getFuserphone() {
		return fuserphone;
	}

	public void setFuserphone(String fuserphone) {
		this.fuserphone = fuserphone == null ? null : fuserphone.trim();
	}

	public String getFstate() {
		return fstate;
	}

	public void setFstate(String fstate) {
		this.fstate = fstate == null ? null : fstate.trim();
	}

	public fault() {
		// TODO Auto-generated constructor stub
	}
	
	public fault(String fhouseid, String fhouseaddress, Double fprice, Date fdate, 
			String fcontent, String fusername, String fuserid, String fuserphone, String fstate,Integer fid) {
		super();
		this.fid = fid;
		this.fhouseid = fhouseid;
		this.fhouseaddress = fhouseaddress;
		this.fprice = fprice;
		this.fdate = fdate;
		this.fcontent = fcontent;
		this.fusername = fusername;
		this.fuserid = fuserid;
		this.fuserphone = fuserphone;
		this.fstate = fstate;
	}
	
}