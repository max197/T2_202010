package controller;

import java.util.Scanner;

import model.data_structures.IQueue;
import model.data_structures.Queue;
import model.logic.Modelo;
import model.logic.Multa;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option)
			{
			case 1:
				view.printMessage("--------- \nCargando los datos... \n");
				modelo = new Modelo(); 
				view.printMessage("Pila y cola creadas\n");
				modelo.cargarDatos();
				view.printMessage("Tope de la pila:");
				view.printMessage(modelo.getStack().getTop().toString() + " \n");
				view.printMessage("Inicio de la cola:");
				view.printMessage(modelo.getQueue().getFirst().toString() + " \n");
				view.printMessage("Numero actual de elementos " + modelo.stackSize() + "\n---------");						
				break;

			case 2:
				view.printMessage("--------- \nHacer cluster por codigo de infraccion : ");
				dato = lector.next();

				try {
					modelo.cluster();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				modelo.cluster();


				modelo.cluster( );

				view.printMessage("Dato agregado");
				/*view.printMessage("Numero actual de elementos " + modelodarTamano() + "\n---------")					
				break;*/


			case 3:
				view.printMessage("--------- \nInserte los N comparendos: ");
				int N = lector.nextInt();
				view.printMessage("\nInserte el codigo de la infraccion:");
				dato = lector.next();
				try 
				{
					IQueue<Multa> cola = (Queue<Multa>) modelo.countFine(N, dato);
					view.printMessage("Numero actual de elementos: " + cola.size() + "\n---------");
					view.printQueue(cola);
				} 
				catch (Exception e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
			case 4: 
				view.printMessage("--------- \n Hasta pronto !! \n---------"); 
				lector.close();
				fin = true;
				break;	

			default: 
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}

	}	
}
