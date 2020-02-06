package view;

import model.data_structures.IQueue;
import model.logic.Modelo;
import model.logic.Multa;

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
			System.out.println("3. N comparendos para una infraccion dada:");
			System.out.println("4. Exit");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}

		public void printMessage(String mensaje) 
		{

			System.out.println(mensaje);
		}		
		
		
		public void printQueue(IQueue<Multa> cola) throws Exception
		{
			while (!cola.isEmpty())
			{
				System.out.println(cola.dequeue().toString() + "\n");
			}

		}
}
