package uniandes.dpoo.aerolinea.modelo.cliente;

import org.json.JSONObject;

/**
 * Esta clase se usa para representar a los clientes de la aerolínea que son empresas
 */
public class ClienteCorporativo extends Cliente
{
    // TODO completar
    public static String CORPORATIVO = "Corporativo";
    public static int GRANDE;
    public static int MEDIANA;
    public static int PEQUEÑA;
    private  int tamanoEmpresa;
    private String nombreEmpresa; 
    
    
    /**
     * Crea un nuevo objeto de tipo a partir de un objeto JSON.
     * 
     * El objeto JSON debe tener dos atributos: nombreEmpresa (una cadena) y tamanoEmpresa (un número).
     * @param cliente El objeto JSON que contiene la información
     * @return El nuevo objeto inicializado con la información
     */
    
    //Los otros metodos como es una clase que hereda no se ponen 

    public ClienteCorporativo(int tamanoEmpresa, String nombreEmpresa) {
		super();
		this.tamanoEmpresa = tamanoEmpresa;
		this.nombreEmpresa = nombreEmpresa;
	}
    
    public int getTamanoEmpresa() {
		return tamanoEmpresa;
	}
    
	public void setTamanoEmpresa(int tamanoEmpresa) {
		this.tamanoEmpresa = tamanoEmpresa;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}






	public static ClienteCorporativo cargarDesdeJSON( JSONObject cliente )
    {
      return null;
        
    }


	/**
     * Salva este objeto de tipo ClienteCorporativo dentro de un objeto JSONObject para que ese objeto se almacene en un archivo
     * @return El objeto JSON con toda la información del cliente corporativo
     */
    public JSONObject salvarEnJSON( )
    {
        JSONObject jobject = new JSONObject( );
        jobject.put( "nombreEmpresa", this.nombreEmpresa );
        jobject.put( "tamanoEmpresa", this.tamanoEmpresa );
        jobject.put( "tipo", CORPORATIVO );
        return jobject;
    }
}
