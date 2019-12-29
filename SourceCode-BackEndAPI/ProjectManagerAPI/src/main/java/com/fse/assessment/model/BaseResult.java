package com.fse.assessment.model;

import static com.fse.assessment.common.ApplicationConstants.STATUS_SUCCESS;
import static com.fse.assessment.common.ApplicationConstants.STATUS_ERROR;
import static com.fse.assessment.common.ApplicationConstants.SYS001;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fse.assessment.common.ApplicationException;


@JsonInclude(Include.NON_NULL)
public class BaseResult {
	
	private String status;
	private ErrorInfo errorInfo;
	
	
	public BaseResult(){
		this.status=STATUS_SUCCESS;
	}
	
	public BaseResult(ApplicationException e){
		this.status=STATUS_ERROR;
		this.errorInfo=new ErrorInfo(e.getAppExCode(), e.getAppExDesc());
	}
	
	public BaseResult(Exception e){
		this.status=STATUS_ERROR;
		this.errorInfo=new ErrorInfo(SYS001, "Unknown Service Exception");
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public ErrorInfo getErrorInfo() {
		return errorInfo;
	}
	public void setErrorInfo(ErrorInfo errorInfo) {
		this.errorInfo = errorInfo;
	}
	

}
