package com.lab4.tp2.parteA.main.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pais implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Basic(optional = false)
    @Column(name = "codigoPais")
    private String codigoPais;

	@Column(name = "numerico_pais")
	private int codigoNumerico;

	@Column(name = "nombre_pais", length = 55, nullable = false)
    private String nombrePais;

	@Column(name = "capital_pais", length = 50, nullable = false)
    private String capitalPais;

	@Column(name = "region", length = 50, nullable = false)
    private String region;

	@Column(name = "poblacion", nullable = false)
    private Long poblacion;

	@Column(name = "latitud", nullable = false)
    private Double latitud;

	@Column(name = "longitud", nullable = false)
    private Double longitud;

	
	
	//Constructores --------------------------------------------------
	public Pais() {
		
	}
	
	public Pais(String codigoPais, int codigoNumerico, String nombrePais, String capitalPais, String region,
			Long poblacion, Double latitud, Double longitud) {
		this.codigoPais = codigoPais;
		this.codigoNumerico = codigoNumerico;
		this.nombrePais = nombrePais;
		this.capitalPais = capitalPais;
		this.region = region;
		this.poblacion = poblacion;
		this.latitud = latitud;
		this.longitud = longitud;
	}

	
	//Getters y setters -----------------------------------------------
	public String getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(String codigoPais) {
		this.codigoPais = codigoPais;
	}

	public int getCodigoNumerico() {
		return codigoNumerico;
	}

	public void setCodigoNumerico(int codigoNumerico) {
		this.codigoNumerico = codigoNumerico;
	}

	public String getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	public String getCapitalPais() {
		return capitalPais;
	}

	public void setCapitalPais(String capitalPais) {
		this.capitalPais = capitalPais;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Long getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(Long poblacion) {
		this.poblacion = poblacion;
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	
	@Override
	public String toString(){
		return
		String.format("%s - %s - %s - %s - %s - %s",
		this.nombrePais ,
		this.capitalPais ,
		this.region ,
		this.poblacion ,
		this.latitud ,
		this.longitud
		);
	}
	
}

