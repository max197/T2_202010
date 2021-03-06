package model.data_structures;

public class Stack<T> implements IStack<T>
{
	/**
	 * Me va a permitir saber cual fue el ultimo que entro a la pila!
	 */
	private Node<T> tope;
	
	/**
	 * Tama�o de la lista
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
			nuevoNodo.cambiarSiguiente(tope);
			tope = nuevoNodo;
		}
		tamanio++;
	}
	
	/**
	 * Borrar un elemento. El elemento tope de la lista
	 * @return Retorna el elemento. Retorna nulo si no hay elementos en la lista.
	 */
	public T pop () throws Exception
	{
		if (tope == null)
			throw new Exception("La pila esta vacia.");
			
		
		T elem = tope.getData();
		Node<T> nextTop = tope.darSiguiente();
		tope.cambiarSiguiente(null);
		tope = nextTop;
		tamanio--;
		return elem;
		
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

	
	/**
	 * Metodo auxiliar para los tests
	 * @return Node nodo que est� en el tope
	 */
	public Node<T> darTope()
	{
		return tope;
	}
	
}
