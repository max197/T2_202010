package view;

import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("1. Cargar los datos de los comparendos en la pila y la cola");
			System.out.println("2. Dar grupo de comparendos consecutivos mas grande por codigo de Infraccion");
			System.out.println("3. Imprimir la pila");
			System.out.println("4. Imprimir la cola");
			System.out.println("5. Exit");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}

		public void printMessage(String mensaje) 
		{

			System.out.println(mensaje);
		}		
		
		
		public void printModelo(Modelo modelo)
		{
			// TODO implementar

		}
}
