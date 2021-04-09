package com.lab4.tp2.parteA.main.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.lab4.tp2.parteA.main.entities.Pais;
import com.lab4.tp2.parteA.main.repositories.PaisRepository;

@Service
public class PaisService {

	@Autowired
	private PaisRepository repository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private String url = "https://restcountries.eu/rest/v2/callingcode/"; 


	/*
		Trae el json principal
		* Utilidades *
			- Contar la cantidad de paises en la posicion actual .size()
			- Contiene los paises .get(index)
	*/
	private JsonArray getArbol(Object paisesURL){				
		return new Gson().toJsonTree(paisesURL).getAsJsonArray();
	}


	/*
		Trae toda la lista de paises segun callingcode(index) -> /callingcode/index
	*/
	private ArrayList<JsonObject> guardar(int index){

		ArrayList<JsonObject> jsonObjectList = new ArrayList<>();
		Object paisesURL = null;
		String urlCompleta = url + index;

		try {
			paisesURL = restTemplate.getForObject(urlCompleta, Object.class);
			for (int j = 0; j < getArbol(paisesURL).size(); j++) {
				jsonObjectList.add(getArbol(paisesURL).get(j).getAsJsonObject());
			}
		} catch(Exception e) {
			
		}
		return jsonObjectList;
	}


	//Crea un pais lo setea y lo devuelve
	private Pais nuevoPais(JsonObject jo){
		Pais pais = new Pais();
			pais.setCodigoPais(jo.get("alpha3Code").getAsString() + jo.get("numericCode").getAsString());
			pais.setCodigoNumerico(jo.get("callingCodes").getAsJsonArray().get(0).getAsInt());
			pais.setNombrePais(jo.get("name").getAsString());
			pais.setCapitalPais(jo.get("capital").getAsString());
			pais.setRegion(jo.get("region").getAsString());
			pais.setPoblacion(jo.get("population").getAsLong());
			pais.setLatitud(jo.get("latlng").getAsJsonArray().get(0).getAsDouble());
			pais.setLongitud(jo.get("latlng").getAsJsonArray().get(1).getAsDouble());
		return pais;
	}	
	
	
	@Transactional
	public List<Pais> getPaises() {
		Pais pais = null;
		for(int i=1; i<=300; i++) {
			for (JsonObject jo : guardar(i)) {
				pais = nuevoPais(jo);
					repository.saveAndFlush(pais);
				System.out.println(pais);
			}
		}
		return repository.findAll();
	}
	
}
