package test.data_structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.Queue;
import model.data_structures.Stack;
import model.logic.Modelo;
import model.logic.Multa;



public class TestStack

{


	private Stack<Multa> pila;
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
		
		
			
		
	}
	
	
	
	@Test 
	
	public void testPush()
	{
		
		setUp1();
		Multa nueva = new Multa(0001, "03/31/1997", "a", "a", "a", "a", "a", "a", 45, 48);
		pila.push(nueva);
		assertEquals("No es el tamaño esperado",21, pila.size());
		

		
		
	}
	
	@Test
	public void testPop()
	{
		
	}
	
	@Test 
	public void testSize()
	{
		
	}
	

	@Test
	public void testIsEmpty()
	{


	}
	@Test
	public void testgetTop()
	{
		
		
	}
	
	
	





}
