package uniandes.dpoo.aerolinea.modelo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.tarifas.CalculadoraTarifas;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public class Vuelo {
	
	private String fecha;
	private Avion avion;
	private Ruta ruta;
	private Map<String, Tiquete> tiquetes;
	
	
	public Collection<Tiquete> getTiquetes(){
		return tiquetes.values(); 
		
	}
	
	public int venderTiquetes(Cliente cliente, CalculadoraTarifas calculadora, int cantidad ) {
		int capacidad = this.getAvion().getCapacidad();
		String tipoCliente = cliente.getTipoCliente();
		int valor = calculadora.calcularTarifa​(this, cliente);
		for(Tiquete tique : this.getTiquetes()) 
		{
			tiquetes.put(this.toString(), tique);
		}
		return valor;
	}
	
	
	public Vuelo(Ruta ruta,String fecha, Avion avion) {
		super();
		this.ruta = ruta;
		this.fecha = fecha;
		this.avion = avion;
		this.tiquetes = new HashMap<>();  
	}
	
	
	
	public Ruta getRuta() {
		return ruta;
	}
	
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public Avion getAvion() {
		return avion;
	}
	
	public void setAvion(Avion avion) {
		this.avion = avion;
	}
	
	

}
