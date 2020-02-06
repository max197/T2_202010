package model.data_structures;

public class Stack<T> implements IStack<T>
{
	/**
	 * Me va a permitir saber cual fue el ultimo que entro a la pila!
	 */
	private Node<T> tope;
	
	/**
	 * Tamaño de la lista
	 */
	private int tamanio;
	
	
	/**
	 * Constructor
	 */
	public Stack()
	{
		tope = null;
		tamanio = 0;
	}
	
	// ----------- METODOS -----------------//
	/**
	 * Insertar un dato en la pila
	 * @param dato. Los datos para crear el nodo y agregar en la pila
	 */
	public void push (T dato )
	{
		Node<T> nuevoNodo = new Node<T>(dato);
		if (tope == null)
		{
			tope = nuevoNodo;
		}
		else
		{
			tope.cambiarSiguiente(nuevoNodo);
			tope = nuevoNodo;
		}
		tamanio++;
	}
	
	/**
	 * Borrar un elemento. El elemento tope de la lista
	 * @return Retorna el elemento. Retorna nulo si no hay elementos en la lista.
	 */
	public T pop ()
	{
		if (tope != null)
		{
			Node<T> aEliminar = tope;
			tope.cambiarSiguiente(null);
			tope = aEliminar.darSiguiente();
			
			tamanio--;
			
			return aEliminar.getData();
		}
		
		return null;
		
	}
	
	/**
	 * Consulta si la pila esta vacia
	 * @return true si esta vacia. false si no
	 */
	public boolean isEmpty( )
	{
		return tamanio==0? true:false;
	}
	/**
	 * Da el top de la pila. 
	 * @return Los datos del tope de la pila
	 */
	public T getTop( )
	{
		return tope.getData();
	}
	
	/**
	 * Dar tamanio
	 * @return el tamanio de la lista
	 */
	public int size()
	{
		return tamanio;
	}

	
	
}
