package test.data_structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.IStack;
import model.data_structures.Queue;
import model.data_structures.Stack;
import model.logic.Modelo;
import model.logic.Multa;



public class TestStack

{


	private IStack<Multa> pila;
	private Modelo modelo;



	@Before
	public void setUp1()
	{
		modelo =  new Modelo();
		pila = modelo.getStack();
		modelo.cargarDatos();
	}


	@Before
	public void setUp2()
	{
		modelo =  new Modelo();
		pila = new Stack<Multa>();


	}

	@Before
	public void setUp3()
	{
		modelo =  new Modelo();
		pila = modelo.getStack();
		modelo.cargarDatos();


		while(!pila.isEmpty())
		{
			try{
				pila.pop();}
			catch(Exception e)
			{
				fail("no debió haber entrado al catch");
			}	
		}


	}



	@Test 
	public void testPush()
	{

		setUp1();
		Multa nueva = new Multa(0001, "03/31/1997", "a", "a", "a", "a", "a", "a", 45, 48);
		Multa nueva1 = new Multa(0003, "03/31/1997", "a", "a", "a", "a", "a", "a", 45, 48);
		pila.push(nueva);

		//Como el indicador es único es suficiente comparando el ID entre ambos objetos
		assertEquals("No es el tamaño esperado",21, pila.size());
		assertEquals("No es el elemento esperado", 0001, pila.getTop().darID());

		//Comparación entre objetos
		assertTrue("No es el elemento esperado", pila.getTop().equals(nueva));

		setUp2();
		pila.push(nueva);
		assertEquals("No se agregó el elemento", 0001, pila.getTop().darID());
		pila.push(nueva1);
		assertEquals("No se agregó correctamente", 0003, pila.getTop().darID());



	}

	@Test
	public void testPop()
	{

		//Verifica que el elemento sacado de la lista sea el que estaba en el tope
		setUp1();
		Multa aSacar = pila.getTop();
		try
		{
			Multa m =  pila.pop();
			assertTrue(m.darID()==aSacar.darID());
			assertEquals("No es el tamaño esperado",19, pila.size());

		}
		catch(Exception e)
		{
			fail("No debio haber entrado al catch");
		}


		//Verifica que la pila no quede vacía antes de eliminar todos los elementos de la pila
		setUp1();
		while(!pila.isEmpty())
		{
			try{
				pila.pop();}
			catch(Exception e)
			{
				fail("no debió haber entrado al catch");
			}	

		}

		setUp2();
		{
			try{
				pila.pop();
				fail("no debió haber entrado al try");
			}
			catch(Exception e)
			{
				assertEquals("Deberia tener tamaño cero",0, pila.size());
				System.out.println("Entró al catch del testDePop");
			}
		}

	}


	@Test
	public void testIsEmpty()
	{
		//Cuando la pila está vacía
		setUp2();
		assertTrue(pila.isEmpty());


		//Verifica que la lista quede vacía cuando se eliminan todos los elementos
		setUp1();
		while(!pila.isEmpty())
		{
			try{
				pila.pop();

			}
			catch(Exception e)
			{
				fail("no debió haber entrado al catch");
			}	

		}
		assertTrue("Debería estar vacía", pila.isEmpty());





	}
	@Test
	public void testgetTop()
	{
		setUp2();
		/*Se usa el metodo darTope() porque con getTop se lanza un NullPointerException*/
		assertNull(pila.darTope());
		


		setUp1();
		Multa esta = pila.getTop();
		
		
		pila.darTope();
		//Rectifica que el tamaño de la cola siga igual 
		assertEquals("Se eliminó cuando no se debería eliminar", 20, pila.size());
		
		/*Rectifica que el elemento consultado por getTop() es el mismo que señala el nodo del tope de la pila.
		 Como el ID es único, basta comparando el id*/
		assertEquals("Se eliminó cuando no debió eliminarse", pila.darTope().getData().darID(), esta.darID());


	}








}
