package com.fse.assessment.model;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public  class BaseResponse implements Serializable {

	private static final long serialVersionUID = -3174514298897132826L;

	
	private BaseResult result;

	public BaseResult getResult() {
		return result;
	}

	public void setResult(BaseResult result) {
		this.result = result;
	}

	


	
}
