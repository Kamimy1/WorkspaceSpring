package com.recetas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "recetas")
public class Recetas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@ManyToOne
	@JoinColumn(name = "FK_dificultad")
	private Dificultades dificultad;

	public Recetas(int id, String nombre, Dificultades dificultad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dificultad = dificultad;
	}

	public Recetas() {
		super();
		this.id = 0;
		this.nombre = "";
		this.dificultad = new Dificultades();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Dificultades getDificultad() {
		return dificultad;
	}

	public void setDificultad(Dificultades dificultad) {
		this.dificultad = dificultad;
	}

	@Override
	public String toString() {
		return "Recetas [id=" + id + ", nombre=" + nombre + ", dificultad=" + dificultad + "]";
	}

}
