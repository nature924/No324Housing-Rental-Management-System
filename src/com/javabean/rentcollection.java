package com.javabean;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
public class rentcollection {
	private Integer rcid;

	private String rchouseid;

	private String rchouseaddress;

	private String rchousemoney;
    @DateTimeFormat(pattern="yyyy-MM-dd")
	private Date rcdate;

	private String rcdatetemp;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date rcpaiddate;

	private String rcpaiddatetemp;
	
	private String rcusername;

	private String rcstate;

	 //修改联表暂时保存的查询字符串
    private String rcusernametemp;
	
	public String getRcusernametemp() {
		return rcusernametemp;
	}

	public void setRcusernametemp(String rcusernametemp) {
		this.rcusernametemp = rcusernametemp;
	}

	public String getRcdatetemp() {
		return rcdatetemp;
	}

	public void setRcdatetemp(String rcdatetemp) {
		this.rcdatetemp = rcdatetemp;
	}

	public String getRcpaiddatetemp() {
		return rcpaiddatetemp;
	}

	public void setRcpaiddatetemp(String rcpaiddatetemp) {
		this.rcpaiddatetemp = rcpaiddatetemp;
	}

	public Date getRcpaiddate() {
		return rcpaiddate;
	}

	public void setRcpaiddate(Date rcpaiddate) {
		this.rcpaiddate = rcpaiddate;
	}

	public Integer getRcid() {
		return rcid;
	}

	public void setRcid(Integer rcid) {
		this.rcid = rcid;
	}

	public String getRchouseid() {
		return rchouseid;
	}

	public void setRchouseid(String rchouseid) {
		this.rchouseid = rchouseid;
	}

	public String getRchouseaddress() {
		return rchouseaddress;
	}

	public void setRchouseaddress(String rchouseaddress) {
		this.rchouseaddress = rchouseaddress == null ? null : rchouseaddress.trim();
	}

	public String getRchousemoney() {
		return rchousemoney;
	}

	public void setRchousemoney(String rchousemoney) {
		this.rchousemoney = rchousemoney == null ? null : rchousemoney.trim();
	}

	public Date getRcdate() {
		return rcdate;
	}

	public void setRcdate(Date rcdate) {
		this.rcdate = rcdate;
	}

	public String getRcusername() {
		return rcusername;
	}

	public void setRcusername(String rcusername) {
		this.rcusername = rcusername == null ? null : rcusername.trim();
	}

	public String getRcstate() {
		return rcstate;
	}

	public void setRcstate(String rcstate) {
		this.rcstate = rcstate == null ? null : rcstate.trim();
	}
}