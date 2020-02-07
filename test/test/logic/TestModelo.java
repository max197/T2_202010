package test.logic;


import static org.junit.Assert.*;
import model.logic.Modelo;

import org.junit.Before;
import org.junit.Test;

public class TestModelo {

	private Modelo modelo;
	private static int CAPACIDAD=100;

	@Before
	public void setUp1() {
		modelo= new Modelo(CAPACIDAD);
	}

	public void setUp2() {
		for(int i =0; i< CAPACIDAD;i++){
			modelo.agregar(i);
		}
	}

	@Test
	public void testModelo() {
		assertTrue(modelo!=null);
		assertEquals(0, modelo.darTamano());  // Modelo con 0 elementos presentes.
	}

	@Test
	public void testDarTamano() {
		// TODO
		setUp2();
		assertEquals("El tamanio deberia ser " + CAPACIDAD + " y es " + modelo.darTamano(), CAPACIDAD, modelo.darTamano());
	}

	@Test
	public void testAgregar() 
	{
		// TODO Completar la prueba
		setUp1();
<<<<<<< HEAD
		modelo.agregar(120);
		assertNotNull("Debio haber agregado un 120 y no lo hizo", modelo.buscar(120));
		
=======
		modelo.agregar("Hola");
		assertNotNull("Debio haber agregado un Hola y no lo hizo", modelo.buscar("Hola"));

>>>>>>> 4a1659a0f7798aec33b284fc4e0d25e258e681bd
		for (int i = 0; i < CAPACIDAD; i++)
		{
			modelo.agregar(i);
			assertNotNull("No esta agregando bien", modelo.buscar(i));
		}

	}

	@Test
	public void testBuscar() {
		setUp2();
		// TODO Completar la prueba

		for (int i = 0; i < CAPACIDAD; i++)
		{
			assertEquals("Se esperaba encontrar " + i + " y se encontro "+ modelo.buscar(i),(int)i, (int)modelo.buscar(i));
		}
	}

	@Test
	public void testEliminar() 
	{
		setUp2();
		// TODO Completar la prueba
		//Caso en que quiera eliminar el primero.
<<<<<<< HEAD
		
		assertEquals((int)0, (int)modelo.eliminar(0));
		
		//Caso en el que quiera eliminar el ultimo
		
		assertEquals((int)(CAPACIDAD-1), (int)modelo.eliminar((CAPACIDAD-1)));
		
		//Caso en el que quiera eliminar alguno en el medio. 
		
		assertEquals((int)(CAPACIDAD-10), (int)modelo.eliminar((CAPACIDAD-10)));
		
		//Eliminar algo que no existe
		
		assertNull(modelo.eliminar(1000));
		
	}
=======

		assertEquals(""+0, modelo.eliminar(""+0));

		//Caso en el que quiera eliminar el ultimo

		assertEquals(""+ (CAPACIDAD-1), modelo.eliminar(""+ (CAPACIDAD-1)));

		//Caso en el que quiera eliminar alguno en el medio. 

		assertEquals("" + (CAPACIDAD-10), modelo.eliminar("" + (CAPACIDAD-10)));

		//Eliminar algo que no existe

		assertNull(modelo.eliminar("X"));
>>>>>>> 4a1659a0f7798aec33b284fc4e0d25e258e681bd

	}
}



