package com.javabean;

import java.util.Date;

public class leaseinformation {
	private Integer houseid;

	private String housecall;

	private String houseaddress;

	private String housetype;

	private Double housesize;

	private String housemoney;

	private String housestate;

	private Date housestartingdate;

	private Date houseclosingdate;

	private String housestartingdatetemp;

	private String houseclosingdatetemp;

	private Integer id;

	private String username;

	private String houserecommend;
	// 希望查询房屋信息的同时房屋的图片链接也是查询好的
	private leaseimg leaseimg;
	private userlist userlist;
	
	
	public userlist getUserlist() {
		return userlist;
	}

	public void setUserlist(userlist userlist) {
		this.userlist = userlist;
	}

	public String getHouserecommend() {
		return houserecommend;
	}

	public void setHouserecommend(String houserecommend) {
		this.houserecommend = houserecommend;
	}

	public leaseimg getLeaseimg() {
		return leaseimg;
	}

	public void setLeaseimg(leaseimg leaseimg) {
		this.leaseimg = leaseimg;
	}

	public String getHousecall() {
		return housecall;
	}

	public void setHousecall(String housecall) {
		this.housecall = housecall;
	}

	public Integer getHouseid() {
		return houseid;
	}

	public void setHouseid(Integer houseid) {
		this.houseid = houseid;
	}

	public String getHouseaddress() {
		return houseaddress;
	}

	public void setHouseaddress(String houseaddress) {
		this.houseaddress = houseaddress == null ? null : houseaddress.trim();
	}

	public String getHousetype() {
		return housetype;
	}

	public void setHousetype(String housetype) {
		this.housetype = housetype == null ? null : housetype.trim();
	}

	public Double getHousesize() {
		return housesize;
	}

	public void setHousesize(Double housesize) {
		this.housesize = housesize;
	}

	public String getHousemoney() {
		return housemoney;
	}

	public void setHousemoney(String housemoney) {
		this.housemoney = housemoney == null ? null : housemoney.trim();
	}

	public String getHousestate() {
		return housestate;
	}

	public void setHousestate(String housestate) {
		this.housestate = housestate == null ? null : housestate.trim();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getHousestartingdate() {
		return housestartingdate;
	}

	public void setHousestartingdate(Date housestartingdate) {
		this.housestartingdate = housestartingdate;
	}

	public Date getHouseclosingdate() {
		return houseclosingdate;
	}

	public void setHouseclosingdate(Date houseclosingdate) {
		this.houseclosingdate = houseclosingdate;
	}

	public String getHousestartingdatetemp() {
		return housestartingdatetemp;
	}

	public void setHousestartingdatetemp(String housestartingdatetemp) {
		this.housestartingdatetemp = housestartingdatetemp;
	}

	public String getHouseclosingdatetemp() {
		return houseclosingdatetemp;
	}

	public void setHouseclosingdatetemp(String houseclosingdatetemp) {
		this.houseclosingdatetemp = houseclosingdatetemp;
	}

}