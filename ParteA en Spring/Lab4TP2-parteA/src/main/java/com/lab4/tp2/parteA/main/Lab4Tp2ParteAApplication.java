package com.lab4.tp2.parteA.main;

//import java.net.HttpURLConnection;
//import java.net.URL;

//import org.json.JSONArray;
//import org.json.JSONObject;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//import com.lab4.tp2.parteA.main.entities.Conexion;
//import com.lab4.tp2.parteA.main.entities.Pais;

@SpringBootApplication
public class Lab4Tp2ParteAApplication {

	/*@Autowired
	Conexion conexion;*/
	
	@Bean //consumimos el rest template para obtener la lista de países
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Lab4Tp2ParteAApplication.class, args);
		
		/*Pais pais = new Pais();
		
		String restUrl = conexion.request("https://restcountries.eu/rest/v2/callingcode/");
		
		JSONObject root = new JSONObject();
		
		JSONArray a = getJSON
		
		for(int i=0; i<=300; i++) {
			
			try {
				URL url = new URL("https://restcountries.eu/rest/v2/callingcode/" + i);
				
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
		        conn.setRequestProperty("Accept", "application/json");
			 
		        Object obj = conn.getContent();
		        
			 
			} catch(Exception e) {
				
			}
			
		}*/
		
		
		
	}

}
