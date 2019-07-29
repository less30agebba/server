package com.taoleg.servercore.common.base;

import lombok.Data;

@Data
public class ResponseBean<T> extends BaseResponse{

	private static final long serialVersionUID = -2941694966710297115L;

	private T data;

	public ResponseBean(){
	}

	public ResponseBean(int code, String msg, T data) {
		super(code, msg);
		this.data = data;
	}

	public ResponseBean(String msg, T data) {
		super(msg);
		this.data = data;
	}

	public ResponseBean(String msg) {
		super(msg);
	}

	public ResponseBean(int code, String msg) {
		super(code, msg);
	}
}
