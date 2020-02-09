package test.logic;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import model.logic.Modelo;

public class TestModelo
{

	private Modelo modelo;

	@Before
	public void setUp1(){		
		modelo = new Modelo();
	}

	@Before
	public void setUp2()
	{
		modelo = new Modelo();
		modelo.cargarDatos();
	}


	@Test
	public void testModelo() {
		assertTrue(modelo!=null);
	}

	@Test
	public void testCargarDatos() 
	{
		assertTrue(modelo!=null);
	}
	
	@Test
	public void TestCluster()
	{

		setUp1();
		try 
		{
			modelo.cluster();
			fail("No debio haber entrado al try");
		}
		catch(Exception e)
		{

		}
		
		setUp2();
		try{
			assertTrue("La cola debería tener al menos un elemento", modelo.cluster().size()>=1);
		}
		catch(Exception e)
		{
			e.getMessage();
			e.printStackTrace();
		}

		//Se genera de nuevo el escenario 2 porque el método cluster vacía la lista original. 
		setUp2();
		try
		{
			assertFalse("La cola no debería tener más de 20 elementos", modelo.cluster().size()>20);
		}
		catch(Exception e){
			e.getMessage();
			e.printStackTrace();
			
		}
		
		//Verifica que no hayan codigos distintos en el cluster
		setUp2();
		try
		{
			String otroCodigo = "";
			String codigo=  modelo.cluster().dequeue().darInfraccion();
			//While de la segunda multa en adelante
			while(!modelo.cluster().isEmpty())
			{

				/*Basta con que una multa tenga un codigo distinto a la primera multa para darse cuenta que el cluster no se ejecutó
				bien */
				
				otroCodigo = modelo.cluster().dequeue().darInfraccion();
				assertTrue("Hay dos codigos distintos de infraccion", otroCodigo.equals(codigo));
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage() + ". No pasó nada malo");

		}

	}
}



