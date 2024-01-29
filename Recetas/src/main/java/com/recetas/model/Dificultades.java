package com.recetas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "dificultades")
public class Dificultades {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "dificultad")
	private String dificultad;

	public Dificultades(int id, String dificultad) {
		super();
		this.id = id;
		this.dificultad = dificultad;
	}

	public Dificultades() {
		super();
		this.id = 0;
		this.dificultad = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDificultad() {
		return dificultad;
	}

	public void setDificultad(String dificultad) {
		this.dificultad = dificultad;
	}

	@Override
	public String toString() {
		return "Dificultades [id=" + id + ", dificultad=" + dificultad + "]";
	}

}