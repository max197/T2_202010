package model.data_structures;

public interface IStack<T>
{
	/**
	 * agregar elementos arriba de la pila
	 */
	public void push(T dato );
	
	
	/**
	 * eliminar 
	 */
	public T pop() throws Exception;
	
	/**
	 * Esta vacio
	 */
	public boolean isEmpty();
	
	/**
	 * Dar el tope de la lista
	 */
	public T getTop( );
	
	/**
	 * Dar tamanio
	 */
	public int size();	
	
	
	/**
	 * Retorna el nodo tope
	 */
	public Node<T> darTope();
}	


