package com.currency;

public class Warning {
	private int WarningJudge;// 0绿色，1黄色，2红色
	private String WarningContent;// 存放内容

	public int getWarningJudge() {
		return WarningJudge;
	}

	public void setWarningJudge(int warningJudge) {
		WarningJudge = warningJudge;
	}

	public String getWarningContent() {
		return WarningContent;
	}

	public void setWarningContent(String warningContent) {
		WarningContent = warningContent;
	}

	public Warning(int warningJudge, String warningContent) {
		super();
		WarningJudge = warningJudge;
		WarningContent = warningContent;
	}

}
