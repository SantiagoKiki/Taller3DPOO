package uniandes.dpoo.aerolinea.modelo.tarifas;

import uniandes.dpoo.aerolinea.modelo.Ruta;
import uniandes.dpoo.aerolinea.modelo.Vuelo;
import uniandes.dpoo.aerolinea.modelo.cliente.Cliente;
import uniandes.dpoo.aerolinea.modelo.cliente.ClienteCorporativo;

public abstract class CalculadoraTarifasTemporadaBaja extends CalculadoraTarifas {
	
	protected int COSTO_POR_KM_NATURAL = 600;
	protected int COSTO_POR_KM_COPORATIVO = 900;
	protected double DESCUENTO_PEQ = 0.02;
	protected double DESCUENTO_MEDIANAS = 0.1;
	protected double DESCUENTO_GRANDES= 0.2;
	

	
	@Override
	public  int calcularTarifa(Vuelo vuelo, Cliente cliente) {
		String tipoCliente = cliente.getTipoCliente();
		if(tipoCliente.equals("Corporativo")) {
			int distancia = calcularDistanciaVuelo(vuelo.getRuta());
			double tarifa = COSTO_POR_KM_COPORATIVO * distancia;
			return (int)tarifa;
		}
		if(tipoCliente.equals("Natural")) {
			int distancia = calcularDistanciaVuelo(vuelo.getRuta());
			double tarifa = COSTO_POR_KM_NATURAL * distancia;
			return (int)tarifa;
		}
		return 0;
		
		}
	
	@Override
	public int calcularCostoBase(Vuelo vuelo, Cliente cliente) {
		// TODO Auto-generated method stub
		int tarifa =calcularTarifa(vuelo, cliente);
		return tarifa;
	}
	
	public double calcularPorcentajeDescuento(ClienteCorporativo cliente) {
		double tam  = cliente.getTamanoEmpresa();
		int valorTiquetes = cliente.calcularValorTotalTiquetes();
		double descuento = valorTiquetes*tam;
		return descuento;
		
	}


}
