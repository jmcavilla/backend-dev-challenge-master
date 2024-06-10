package com.directa24.main.challenge.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;

@Data
public class DirectaResponseDTO {
	@JsonProperty("page")
	private int page;
	@JsonProperty("per_page")
	private int per_page;
	@JsonProperty("total")
	private int total;
	@JsonProperty("total_pages")
	private int total_pages;
	@JsonProperty("data")
	@Getter
	private List<MovieDTO> data;
	@Override
	public String toString() {
		return "ResponseDTO [page=" + page + ", per_page=" + per_page + ", total=" + total + ", total_pages="
				+ total_pages + ", data=" + data + "]";
	}
	
	
}
