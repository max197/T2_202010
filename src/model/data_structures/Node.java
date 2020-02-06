package model.data_structures;

public class Node <E>
{
	/**
	 * atributos que se refiere a los datos
	 */
	private E datos;
	
	/**
	 * Atributo que se refiere al siguiente
	 */
	private Node<E> siguiente;
	
	/**
	 * Constructor de la clase
	 * @param datos Lo que va a contener el nodo
	 */
	public Node (E datos)
	{
		siguiente = null;
		this.datos = datos;
	}
	
	// METODOS ---------------------------
	
	/**
	 * dar datos
	 */
	public E getData ()
	{
		return datos;
	}
	
	/**
	 * Set datos
	 */
	public void asignarDatos ( E datos )
	{
		this.datos = datos;
	}
	
	/**
	 * Cambiar siguiente. 
	 * @param elSiguiente siguiente nodo. 
	 */
	public void cambiarSiguiente ( Node<E> elSiguiente )
	{
		siguiente = elSiguiente;
	}
	
	/**
	 * Dar siguiente
	 * @return El siguiente nodo
	 */
	public Node<E> darSiguiente()
	{
		return siguiente;
	}
	
	
	
	
}
