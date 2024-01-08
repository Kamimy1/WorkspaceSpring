package com.holamundo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="pelicula")
public class Pelicula {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="pelicula")
	private String pelicula;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="nota")
	private Double nota;

	public Pelicula(int id, String pelicula, String descripcion, Double nota) {
		super();
		this.id = id;
		this.pelicula = pelicula;
		this.descripcion = descripcion;
		this.nota = nota;
	}
	
	public Pelicula() {
		super();
		this.id = 0;
		this.pelicula = "";
		this.descripcion = "";
		this.nota = 0.0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPelicula() {
		return pelicula;
	}

	public void setPelicula(String pelicula) {
		this.pelicula = pelicula;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", pelicula=" + pelicula + ", descripcion=" + descripcion + ", nota=" + nota
				+ "]";
	}
	
	

}
