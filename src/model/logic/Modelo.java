package model.logic;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import model.data_structures.IQueue;
import model.data_structures.IStack;
import model.data_structures.Queue;
import model.data_structures.Stack;

/**
 * Definicion del modelo del mundo
 * @param <T>
 *
 */
public class Modelo
{
	/**
	 * Atributos del modelo del mundo
	 */
	private Stack<Multa> stack;

	private Queue<Multa> queue;


	/**
	 * Constructor del modelo del mundo. Crea la pila y la cola.
	 */
	public Modelo()
	{
		stack = new Stack<Multa>();
		queue = new Queue<Multa>();
	}


	/**
	 * Requerimiento 1. Cargar datos.
	 * Carga los datos del archivo Json que esta contenido en el proyecto.
	 */
	public void cargarDatos()
	{

		JSONParser parser = new JSONParser();

		try
		{
			Object obj = parser.parse(new FileReader("./data/comparendos_dei_2018_small.geojson"));
			JSONObject jsonObject = (JSONObject) obj;

			JSONArray featuresArray = (JSONArray) jsonObject.get("features");
			Iterator iter = featuresArray.iterator();

			ArrayList<Double> latitud = new ArrayList<Double>();
			ArrayList<Double> longitud = new ArrayList<Double>();

			int j = 0;

			while(iter.hasNext())
			{
				JSONObject objetoJson = (JSONObject) iter.next();


				JSONObject properties = ( JSONObject ) objetoJson.get("properties");
				long objectID = ( long ) properties.get("OBJECTID");
				String localidad = ( String ) properties.get("LOCALIDAD");
				String des_infrac = ( String ) properties.get("DES_INFRAC");
				String fecha = ( String ) properties.get("FECHA_HORA");
				String medio_dete = ( String ) properties.get("MEDIO_DETE");
				String clase_vehi = ( String ) properties.get("CLASE_VEHI");
				String tipo_servi = ( String ) properties.get("TIPO_SERVI");
				String infraccion = ( String ) properties.get("INFRACCION");


				JSONObject geometry = ( JSONObject ) objetoJson.get("geometry");
				JSONArray coordenadas = ( JSONArray ) geometry.get("coordinates");
				Iterator iter2 = coordenadas.iterator();


				int i = 0;

				while (iter2.hasNext())
				{
					Number lat_long = ( Number ) iter2.next();
					double double_lat_long = lat_long.doubleValue();
					if (i % 2 == 0)
					{
						latitud.add(double_lat_long);
					}
					else
					{
						longitud.add(double_lat_long);
					}
					i++;
				}
				if (latitud.contains(0.0))
				{
					for (int k = 0; i < latitud.size(); i++)
					{
						if (latitud.get(k) == 0.0)
						{
							latitud.remove(k);
						}
					}
				}

				//Crear la multa y el nodo para agregarlo a la lista. 
				Multa multa = new Multa(objectID, fecha, medio_dete, clase_vehi, tipo_servi, infraccion,
						des_infrac, localidad, latitud.get(j), longitud.get(j));

				addStack(multa);
				addQueue(multa);


				j++;
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(ParseException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Requerimiento 3: Contar los N comparendos de una infraccion dada.
	 * Retorna la cola vacia si no hay nada en la pila.
	 */
	public IQueue<Multa> countFine (int N, String infraccion ) throws Exception
	{
		IQueue<Multa> nuevaCola = new Queue<Multa>();
		int i = N;
		while (i > 0 && !stack.isEmpty())
		{

			Multa multaTope = stack.pop();

			if (multaTope.darInfraccion().equals(infraccion))
			{
				nuevaCola.enqueue(multaTope);
				i--;
			}
		}

		return nuevaCola;
	}

	/**
	 * Requerimiento 2. 
	 * Hacer un cluster con el grupo consecutivo que mas se repite de la cola
	 * @return una nueva cola con los comparendos resultantes.
	 * @return Exception si no hay datos cargados
	 */
	public Queue<Multa> cluster() throws Exception
	{

		/*String auxiliar que permite saber si se cambia de cluster. Por defecto la infracci�n anterior se inicializa 
		con  la primera multa en la cola*/
		if(queue.isEmpty())
			throw new Exception("La cola no tiene elementos cargados");
						
		String infraccionAnterior =  queue.darPrimero().getData().darInfraccion();
		
		//El queue que retornar� el m�todo
		Queue<Multa> cola =  new Queue<Multa>();
		
		//Queues auxiliares
		Queue<Multa> c1 = new Queue<Multa>();

		Queue<Multa> c2 = new Queue<Multa>();

		while(!queue.isEmpty())
		{
			//Variable que identifica la multa eliminada del queue
			Multa m = queue.dequeue();

			String infraccionActual = m.darInfraccion();

			if(infraccionActual.equals(infraccionAnterior))
			{
				c1.enqueue(m);
				c2 = c1;

				infraccionAnterior =  infraccionActual;
			}
			else
			{
				if(c2.size()>= cola.size())
					cola = c2;

				c1 = new Queue<Multa>();
				c1.enqueue(m);
				infraccionAnterior =  infraccionActual;
			}
		}

		return cola;

	}

	/**
	 * Servicio de consulta de numero de elementos presentes en la pila 
	 * @return numero de elementos presentes en la pila
	 */
	public int stackSize()
	{
		return stack.size();
	}

	/**
	 * Servicio de consulta de numero de elementos presentes en la cola
	 * @return numero de elementos presentes en la cola
	 */
	public int queueSize()
	{
		return queue.size();
	}


	/**
	 * Agregar los datos al stack
	 * @param dato
	 */
	public void addStack(Multa dato)
	{	
		stack.push(dato);
	}

	/**
	 * Agregar los datos a la cola
	 * @param dato
	 */
	public void addQueue(Multa dato)
	{	
		queue.enqueue(dato);
	}

	/**
	 * dar toda la pila
	 */
	public Stack<Multa> getStack()
	{
		return stack;
	}

	/**
	 * Dar toda la cola
	 */
	public Queue<Multa> getQueue()
	{
		return queue;
	}

}
