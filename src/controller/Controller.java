package controller;

import java.util.Scanner;

import model.logic.Modelo;
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
					modelo.cluster();
					view.printMessage("Dato agregado");
					//view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;
				case 3:
					view.printMessage("--------- \nImprimir la cola: ");
					dato = lector.next();
					//respuesta = modelo.eliminar(dato);
					if ( respuesta != null)
					{
						view.printMessage("Dato eliminado "+ respuesta);
					}
					else
					{
						view.printMessage("Dato NO eliminado");							
					}
					//view.printMessage("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
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
