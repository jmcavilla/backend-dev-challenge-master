package com.directa24.main.challenge.services.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.directa24.main.challenge.dto.MovieDTO;
import com.directa24.main.challenge.dto.DirectaResponseDTO;
import com.directa24.main.challenge.services.IDirectaService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DirectaServiceImpl implements IDirectaService {
	private final static String BASE_URL = "https://directa24-movies.wiremockapi.cloud/api/movies/search?page=";

	public List<String> getDirectors(String threshold, String page) {
		List<String> directors = new ArrayList<String>();

		URL url = null;
		try {
			url = new URL(BASE_URL + page);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		HttpURLConnection connection;
		InputStream responseStream;
		ObjectMapper mapper = new ObjectMapper();
		DirectaResponseDTO resp = null;
		try {
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestProperty("accept", "application/json");
			responseStream = connection.getInputStream();
			resp = mapper.readValue(responseStream, DirectaResponseDTO.class);
		} catch (IOException e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Ocurrio un error inesperado");
		}

		System.out.println(resp);
		Map<Object, List<MovieDTO>> directorsGrouped = resp.getData().stream()
				.collect(Collectors.groupingBy(w -> w.director));

		directorsGrouped.forEach((k, v) -> {
			if (v.size() >= Integer.valueOf(threshold))
				directors.add(k.toString());
		});

		System.out.println(directors);

		return directors;
	}
}
