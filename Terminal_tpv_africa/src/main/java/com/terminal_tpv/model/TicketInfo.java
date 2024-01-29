package com.terminal_tpv.model;

import java.util.HashMap;
import java.util.Map;

public class TicketInfo {
	
	private int id;
    private String fecha;
    private String hora;
    private Map<String, Integer> productos;

    public TicketInfo(int id, String fecha, String hora) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.productos = new HashMap<>();
    }

    public void agregarProducto(String nombreProducto, int cantidad) {
        productos.put(nombreProducto, cantidad);
    }

    public int getId() {
        return id;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public Map<String, Integer> getProductos() {
        return productos;
    }

}
