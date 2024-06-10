package com.directa24.main.challenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.directa24.main.challenge.dto.ResponseDTO;
import com.directa24.main.challenge.services.IDirectaService;

@RestController
@RequestMapping("/directors")
public class DirectorsController {
	
	@Autowired
	private IDirectaService service;
	
	@GetMapping(value = "/{page}/{threshold}" , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDTO> getDirectors(@PathVariable(name = "threshold") String threshold, @PathVariable(name = "page") String page) {
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(this.service.getDirectors(threshold, page), HttpStatus.OK), HttpStatus.OK);
	}

}
