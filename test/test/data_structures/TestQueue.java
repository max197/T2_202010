package test.data_structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNull;

import model.data_structures.Queue;
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
		modelo =  new Modelo();
		cola = new Queue<Multa>();

	}
	
	/**
	 * Vac�a la lista despu�s de haberla cargado
	 */
	@Before
	public void setUp3()
	{
		modelo =  new Modelo();
		cola = modelo.getQueue();
		modelo.cargarDatos();
		
		try
		{
			while(!cola.isEmpty())		
				cola.dequeue();	
		}
		catch(Exception e)
		{
			fail("no debi� haber entrado al catch");
		}
		
	}
	
	@Test 
	public void testEnqueue()
	{

		setUp1();
		Multa nueva = new Multa(0001, "03/31/1997", "a", "a", "a", "a", "a", "a", 45, 48);
		Multa nueva1 = new Multa(0002, "03/31/1997", "a", "a", "a", "a", "a", "a", 45, 48);

		cola.enqueue(nueva);
		assertEquals("No es el tama�o esperado", 21, cola.size());
		//Como el id es �nico, es suficiente comparando el ID entre los dos objectos
		assertEquals("No es el elemento esperado", 0001, cola.darUltimo().getData().darID());

		cola.enqueue(nueva1);
		assertEquals("No es el tama�o esperado", 22, cola.size());
		assertEquals("No es el elemento esperado", 0002, cola.darUltimo().getData().darID());

	}

	@Test
	public void testDequeue()
	{
		setUp1();
		 //Verifica que el elemento sacado de la lista sea el que estaba al inicio
		try{
			assertEquals("No era el elemento que deb�a ser eliminado", 29042, cola.dequeue().darID());
		}
		catch(Exception e)
		{
			fail("no debi� haber entrado al catch");
			System.out.println(e);
		}


		assertEquals("No es el tama�o esperado", 19, cola.size());
		assertEquals("El primer elemento deber�a ser otro", 509329, cola.getFirst().darID() );

		setUp3();
		try
		{
			cola.dequeue();
			fail("No debio haber entrado al try");

		}
		catch(Exception e)
		{
			System.out.println("Entr� al catch del testDequeue");
			
		}



	}

	@Test
	public void testIsEmpty()
	{

		setUp2();
		assertTrue(cola.isEmpty());
		
		setUp1();
		assertFalse(cola.isEmpty());

	}
	
	
	@Test
	public void testgetFirst()
	{
		
		setUp2();
		assertNull("Deberia ser null", cola.darPrimero());
		
		setUp1();
		assertNotNull("No deberia ser null", cola.darPrimero());
		
		setUp3();
		assertNull("Deber�a ser null", cola.darPrimero());
		
		setUp1();
		Multa esta = cola.getFirst();
		//Rectifica que el tama�o de la cola siga igual 
		assertEquals("Se elimin� cuando no debi� haber eliminado", 20, cola.size());
		/*Rectifica que el elemento consultado por getFirst() es el mismo que se�ala el primer nodo de la cola.
		 Como el ID es �nico, basta comparando el id*/
		assertEquals("Se elimin� cuando no debi� eliminarse", cola.darPrimero().getData().darID(), esta.darID());
		
		
		
	
	}
}

