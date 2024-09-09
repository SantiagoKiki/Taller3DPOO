package uniandes.dpoo.aerolinea.modelo.cliente;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class Cliente {
	
	
	String identificador;
	String tipoCliente;
    private List<Tiquete> tiquetesUsados;
    private List<Tiquete> tiquetesSinUsar;

	
	public Cliente(){
		this.tiquetesSinUsar = new ArrayList<Tiquete>();
		this.tiquetesUsados = new ArrayList<Tiquete>();
	}
	
	public String getTipoCliente() {
		return this.tipoCliente;
	}
	
	public String getIdentificador() {
		return this.identificador;
	}
	
	public void agregarTiquete(Tiquete  tiquete) {
		tiquetesSinUsar.add(tiquete);
	}
	
	public void usarTiquetes(Vuelo vuelo) {
		 Collection<Tiquete> iterator = vuelo.getTiquetes();
		 for(Tiquete elementos : iterator) {
			 for(Tiquete elementos2 : tiquetesSinUsar) {
				 if (elementos.equals(elementos2)) {
					 tiquetesSinUsar.remove(elementos2);
				 }
			 }
				 
			 tiquetesUsados.add(elementos);
		 }
	}

	public List<Tiquete> getTiquetesUsados() {
		return tiquetesUsados;
	}

	public void setTiquetesUsados(List<Tiquete> tiquetesUsados) {
		this.tiquetesUsados = tiquetesUsados;
	}

	public List<Tiquete> getTiquetesSinUsar() {
		return tiquetesSinUsar;
	}

	public void setTiquetesSinUsar(List<Tiquete> tiquetesSinUsar) {
		this.tiquetesSinUsar = tiquetesSinUsar;
	}

	public int calcularValorTotalTiquetes() { 
		int tarifa = 0;
		for(Tiquete elementos : tiquetesUsados) 
		{
			tarifa += elementos.getTarifa(); 
		}
		for(Tiquete elementos : tiquetesSinUsar) 
		{
			tarifa += elementos.getTarifa();
		}
		return tarifa;
	}
	
}
