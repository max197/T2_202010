package test.data_structures;

import model.data_structures.ArregloDinamico;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestArregloDinamico {

	private ArregloDinamico arreglo;
	private static int TAMANO=100;
	
	@Before
	public void setUp1() 
	{
		arreglo= new ArregloDinamico(TAMANO);
	}

	public void setUp2() 
	{
		for(int i =0; i< TAMANO*2; i++){
			arreglo.agregar(""+i);
		}
	}

	@Test
	//testea si se crea bien el arreglo dinamico. Es decir, se tiene que crear de tamaño = TAMANO
	public void testArregloDinamico() 
	{
		// TODO
		setUp1(); // crea el arreglo
		assertEquals("El tamanio actual deberia ser 0", 0, arreglo.darTamano());
		assertEquals("El tamanio maximo deberia ser " + TAMANO, TAMANO, arreglo.darCapacidad());
	}

	@Test
	public void testDarElemento() {
		setUp2();
		// TODO
		for (int i = 0; i < TAMANO*2; i++)
		{
			assertEquals("El metodo de agregar o de dar elemento tienen un error", ""+i, arreglo.darElemento(i));
		}
	}

}
