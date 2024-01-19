package com.AMBM.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mascotas")
public class Mascota {

	@Id // primary key y not null
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "edad")
	private int edad;

	@Column(name = "descripcion")
	private String descripcion;

	@Column(name = "foto")
	private String foto;
	
	@ManyToOne
	private Especie Especie;
	
	@ManyToOne
	private Provincia Provincia;

	
	public Mascota(int id, String nombre, int edad, String descripcion, String foto, com.AMBM.model.Especie especie,
			com.AMBM.model.Provincia provincia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.descripcion = descripcion;
		this.foto = foto;
		Especie = especie;
		Provincia = provincia;
	}
	
	public Mascota() {
		super();
		this.id = 0;
		this.nombre = "";
		this.edad = 0;
		this.descripcion = "";
		this.foto = "";
		Especie = new Especie();
		Provincia = new Provincia();
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Especie getEspecie() {
		return Especie;
	}

	public void setEspecie(Especie especie) {
		Especie = especie;
	}

	public Provincia getProvincia() {
		return Provincia;
	}

	public void setProvincia(Provincia provincia) {
		Provincia = provincia;
	}

	@Override
	public String toString() {
		return "Mascota [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", descripcion=" + descripcion
				+ ", foto=" + foto + ", Especie=" + Especie + ", Provincia=" + Provincia + "]";
	}

}
