package model.data_structures;

public interface ICola<E> {
	
	
	/**
	 * Agregar un elemento al tope de la cola -push
	 * @param pElem elemento genérico
	 */
	public void enqueue(E pElem );
	
	
	/**
	 *Obtener el elemento que está en el tope de la cola, retirándola de la estructura de datos
	 *@return elemento eliminado 
	 */
	E dequeue();
	
	
	/**
	 * Consulta el tamaño del queue
	 * @return int tamaño del queue
	 */
	int size();
	
	
	/**
	 * Verifica si la cola está vacía
	 * @return verdadero o falso, dependiendo si está vacía o no la cola
	 */
	boolean isEmpty();
	
	/**
	 * Consultar elemento del principio de la cola
	 * @return elem elemento del principio
	 */
	E peek();

}
