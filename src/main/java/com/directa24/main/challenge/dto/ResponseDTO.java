package com.directa24.main.challenge.dto;

import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ResponseDTO {

	public ResponseDTO(Object data, HttpStatus status) {
		this.data = data;
		this.status = status;
	}

	public HttpStatus status;
	public Object data;

}
