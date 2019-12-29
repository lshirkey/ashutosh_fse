package com.fse.assessment.common;

public class ApplicationException extends Exception{

	
	private static final long serialVersionUID = 1L;
	
	private String appExCode;
	private String appExDesc;
	
	public String getAppExCode() {
		return appExCode;
	}
	public void setAppExCode(String appExCode) {
		this.appExCode = appExCode;
	}
	public String getAppExDesc() {
		return appExDesc;
	}
	public void setAppExDesc(String appExDesc) {
		this.appExDesc = appExDesc;
	}

	

}
