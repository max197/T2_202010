package model.data_structures;

public interface ICola<E> {
	
	
	/**
	 * Agregar un elemento al tope de la pila -push
	 * @param pElem elemento genérico
	 */
	public void push(E pElem );
	
	
	/**
	 *Obtener el elemento que está en el tope de la pila, retirándolode la estructura de datos - pop
	 *@return elemento eliminado 
	 */
	E pop();
	
	
	/**
	 * Consulta el tamaño del queue
	 * @return int tamaño del queue
	 */
	int size();
	
	
	/**
	 * Verificas si la lista está vacía
	 * @return verdadero o falso, dependiendo si está vacía o no la cola
	 */
	boolean isEmpty();
	
	

}
