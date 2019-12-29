package com.fse.assessment.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ErrorInfo implements Serializable {
	private static final long serialVersionUID = -3506107965770628658L;
	private String code;
	private String desc;

	public ErrorInfo(String sys001, String erroDesc) {
		this.code=sys001;
		this.desc=erroDesc;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}