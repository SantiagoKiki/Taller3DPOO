package uniandes.dpoo.aerolinea.modelo.tarifas;

import java.util.Collection;

import uniandes.dpoo.aerolinea.modelo.Aeropuerto;
import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.tiquetes.Tiquete;

public abstract class CalculadoraTarifas {

	static double	IMPUESTO = 0.28;
	
	
	
	public CalculadoraTarifas() {
		super();
	}
	
	public  int calcularTarifa(Vuelo vuelo, Cliente cliente) {
		return 0;
		}

	protected abstract int calcularCostoBase(Vuelo vuelo, Cliente cliente);
	
	 
	protected abstract double calcularPorcentajeDescuento(Cliente E) ;
		
	
	protected  int calcularValorImpuestos(int costoBase){
		return (int) (costoBase*IMPUESTO);
	}
	
	protected int calcularDistanciaVuelo(Ruta ruta) {
		Aeropuerto destino = ruta.getDestino();
		Aeropuerto salida = ruta.getOrigen();
		double latiDestino = destino.getLatitud();
		double longiDestino = destino.getLongitud();
		double latiOrigen = destino.getLatitud();
		double longiOrigen = destino.getLongitud();
		latiDestino = degToRad(latiDestino);
		longiDestino = degToRad(longiDestino);
		latiOrigen = degToRad(latiOrigen);
		longiOrigen = degToRad(longiOrigen);
		
		double distance = calculateDistance(latiDestino, longiDestino, latiOrigen, longiOrigen);
		
		return (int) distance;
		
	}
	
    public static double degToRad(double degrees) {
        return degrees * Math.PI / 180;
    }

    public static double calculateDistance(double latiDestino, double longiDestino, double latiOrigen, double longiOrigen) {
        final int R = 6371; // Radio de la Tierra en kilómetros

        double deltaLat = latiOrigen - latiDestino;
        double deltaLon = longiOrigen - longiDestino;

        double a = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2)
                 + Math.cos(latiDestino) * Math.cos(latiOrigen)
                 + Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return R * c;
    }

	
}
	

