package test.data_structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.Queue;
import model.data_structures.Stack;
import model.logic.Modelo;
import model.logic.Multa;

public class TestQueue {

	private Queue<Multa> cola;
	private Modelo modelo;

	/**
	 * Escenario 1
	 * Carga un queue con los elementos del archivo small.geojson
	 */
	@Before
	public void setUp1()
	{
		
		modelo =  new Modelo();
		cola = modelo.getQueue();
		modelo.cargarDatos();
		System.out.println(cola.darUltimo().getData().darID());
		
		

	}
	
	
	/**
	 * Inicializa un queue vacio 
	 */
	@Before
	public void setUp2()
	{
		modelo = new Modelo();
		cola = new Queue<Multa>();
		
	}
	
	@Test 
	public void testEnqueue()
	{

		setUp1();
		Multa nueva = new Multa(0001, "03/31/1997", "a", "a", "a", "a", "a", "a", 45, 48);
		
		cola.enqueue(nueva);
		assertEquals("No es el tamaño esperado", 21, cola.size());
		assertEquals("No es el elemento esperado", 0001, cola.darUltimo().getData().darID());


	}

	@Test
	public void testDequeue()
	{
		setUp1();
		
		assertEquals("No era el elemento que debía ser eliminado", 29042, cola.dequeue().darID());
		System.out.println(cola.darUltimo().getData().darID());
		System.out.println(cola.size());
		assertEquals("No es el tamaño esperado", 19, cola.size());
		assertEquals("El primer elemento debería ser otro", 509329);

		

	}

	@Test 
	public void testSize()
	{
		
		setUp1();
		

	}

	@Test
	public void testIsEmpty()
	{


	}
	@Test
	public void testgetFirst()
	{


	}
}

