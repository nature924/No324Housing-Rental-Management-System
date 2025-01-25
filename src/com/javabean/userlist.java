package com.javabean;

public class userlist {
	private Integer id;
	
    private String userid;

    private String username;

    private String usercall;

    private String userpwd;

    private String useremail;

    private String userphone;

    //修改联表暂时保存的查询字符串
    private String usernametemp;
    
    //	关联房屋
    private leaseinformation leaseinformation;
    
    public String getUsernametemp() {
		return usernametemp;
	}

	public void setUsernametemp(String usernametemp) {
		this.usernametemp = usernametemp;
	}

	public leaseinformation getLeaseinformation() {
		return leaseinformation;
	}

	public void setLeaseinformation(leaseinformation leaseinformation) {
		this.leaseinformation = leaseinformation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUsercall() {
        return usercall;
    }

    public void setUsercall(String usercall) {
        this.usercall = usercall == null ? null : usercall.trim();
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd == null ? null : userpwd.trim();
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail == null ? null : useremail.trim();
    }

    public String getUserphone() {
        return userphone;
    }

    public void setUserphone(String userphone) {
        this.userphone = userphone == null ? null : userphone.trim();
    }
}