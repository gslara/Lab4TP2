package com.lab4.tp2.parteA.main.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lab4.tp2.parteA.main.services.PaisService;

@RestController
public class PaisController {

	@Autowired
	private PaisService service;


	@GetMapping("/paises")
	@Transactional
	private ResponseEntity<?> getPaises(){

		try {
			return ResponseEntity.status(HttpStatus.OK).body(service.getPaises());
			
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\": \"Error. Países no encontrados.\"}");
		}
	}
	
}