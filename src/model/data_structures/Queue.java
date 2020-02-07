package model.data_structures;

public class Queue<T> implements IQueue<T>
{
	/**
	 * Referencia al primer objeto de la cola
	 * El primero es el primero que se inserto, es decir, es el primero que se va a eliminar
	 */
	private Node<T> primero;
	
	/**
	 * Referencia al ultimo objeto de la cola 
	 * El ultimo es el ultimo que entro. Este cambia cada vez que entra alguien.
	 */
	private Node<T> ultimo;
	
	/**
	 * Tamanio de la lista
	 */
	private int tamanio;
	
	/**
	 * Constructor
	 */
	public Queue()
	{
		primero = null;
		ultimo = null;
		tamanio = 0;
	}
	
	// --------- METODOS -----------
	/**
	 * Encola los elementos.
	 * @param dato para crear el nodo y meter en la cola
	 */
	public void enqueue(T dato)
	{
		Node<T> nodoNuevo = new Node<T> (dato);
		//Si no hay nada en la cola, el primero en entrar es el paramentro y el ultimo tambien
		if (primero == null)
		{
			primero = nodoNuevo;
			ultimo = nodoNuevo;
		}
		else
		{
			ultimo.cambiarSiguiente(nodoNuevo);
			ultimo = nodoNuevo;
		}
		tamanio++;
	}
	/**
	 * Saca el elemento del principio, es decir, el primero
	 * @return el elemento que elimino. Null si no habia nada.
	 */
	public T dequeue( ) throws Exception
	{
		if (tamanio == 0)
			throw new Exception("La cola no tiene objetos para sacar");
		Node<T> viejoPrimero = primero;
		T elem = viejoPrimero.getData();
		primero = viejoPrimero.darSiguiente();
		viejoPrimero.cambiarSiguiente(null);
		tamanio--;
		return elem;
			
		
	}
	/**
	 * Tamanio de la cola
	 * @return numero con el tamanio de la cola
	 */
	public int size()
	{
		return tamanio;
	}
	
	/**
	 * Mira si la cola esta vacia
	 * @return verdadero si esta vacia, falso si no.
	 */
	public boolean isEmpty()
	{
		return tamanio==0? true: false;
	}
	
	/**
	 * Consulta el elemento del principio de la cola sin eliminarlo
	 * @return T Retorna el primer elemento
	 */
	public T getFirst()
	{
		return primero.getData();
	}
	
	
	
	/**
	 * Metodo para utilizar en los test
	 * @return T retorna el ultimo Nodo<T> de la queue
	 */
	public Node<T> darUltimo()
	{
		return ultimo;
	}
	
	
}
