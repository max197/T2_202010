package model.data_structures;

public interface ICola<E> {
	
	
	/**
	 * Agregar un elemento al tope de la cola -push
	 * @param pElem elemento gen�rico
	 */
	public void enqueue(E pElem );
	
	
	/**
	 *Obtener el elemento que est� en el tope de la cola, retir�ndola de la estructura de datos
	 *@return elemento eliminado 
	 */
	E dequeue();
	
	
	/**
	 * Consulta el tama�o del queue
	 * @return int tama�o del queue
	 */
	int size();
	
	
	/**
	 * Verifica si la cola est� vac�a
	 * @return verdadero o falso, dependiendo si est� vac�a o no la cola
	 */
	boolean isEmpty();
	
	/**
	 * Consultar elemento del principio de la cola
	 * @return elem elemento del principio
	 */
	E peek();

}
