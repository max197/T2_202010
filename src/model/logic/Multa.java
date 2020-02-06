package model.logic;


public class Multa
{
	//Atributos//
	
	/**
	 * Identificador unico del comparendo
	 */
	private long OBJECTID;
	
	/**
	 * Fecha del comparendo, formato: año/mes/dia
	 */
	private String FECHA_HORA;
	
	/**
	 * 
	 */
	private String MEDIO_DETE;
	
	/**
	 * Tipo del vehiculo
	 */
	private String CLASE_VEHI;
	
	/**
	 * Tipo de servicio
	 */
	private String TIPO_SERVI;
	
	/**
	 * Codigo de infraccion cometida
	 */
	private String INFRACCION;
	
	/**
	 * Descripcion de la infracion
	 */
	private String DES_INFRAC;
	
	/**
	 * Localidad
	 */
	private String LOCALIDAD;
	
	/**
	 * Latitud del comparendo
	 */
	private double latitud;
	
	/**
	 * Longitud del comparendo
	 */
	private double longitud;
	
	//
	//Constructor
	//
	/**
	 * Para crear objetos de tipo Multa.
	 * @param objectID
	 * @param fecha_hora
	 * @param medio_dete
	 * @param clase_vehi
	 * @param tipo_servi
	 * @param infraccion
	 * @param des_infrac
	 * @param localidad
	 * @param latitud
	 * @param longitud
	 */
	public Multa(long objectID, String fecha_hora, String medio_dete, String clase_vehi, String tipo_servi,
			String infraccion, String des_infrac, String localidad, double pLatitud, double pLongitud)
	{
		OBJECTID = objectID;
		FECHA_HORA = fecha_hora;
		MEDIO_DETE = medio_dete;
		CLASE_VEHI = clase_vehi;
		TIPO_SERVI = tipo_servi;
		INFRACCION = infraccion;
		DES_INFRAC = des_infrac;
		LOCALIDAD = localidad;
		latitud = pLatitud;
		longitud = pLongitud;
	}
	
	//
	//METODOS para dar informacion
	//
	
	public long darID()
	{
		return OBJECTID;
	}
	
	public String darFecha()
	{
		return FECHA_HORA;
	}
	
	public String darMedioDete()
	{
		return MEDIO_DETE;
	}
	
	public String darClaseVehiculo()
	{
		return CLASE_VEHI;
	}
	
	public String darTipoServicio()
	{
		return TIPO_SERVI;
	}
	
	public String darInfraccion()
	{
		return INFRACCION;
	}
	
	public String darDescripcionInfraccion()
	{
		return DES_INFRAC;
	}
	
	public String darLocalidad()
	{
		return LOCALIDAD;
	}
	
	public double darLatitud ()
	{
		return latitud;
	}
	
	public double darLongitud() 
	{
		return longitud;
	}
	@Override
	public String toString ()
	{
		return ("ID: " + OBJECTID + " - Fecha: " + FECHA_HORA + " - Infraccion: " + INFRACCION + 
				"\nTipo Vehiculo: " + CLASE_VEHI + " - Tipo de Servicio: " + TIPO_SERVI + 
				" - Localidad: " + LOCALIDAD );
	}


	
	
}
