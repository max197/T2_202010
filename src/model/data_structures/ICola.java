package model.data_structures;

public interface ICola<E> {
	
	
	/**
	 * Agregar un elemento al tope de la pila -push
	 * @param pElem elemento gen�rico
	 */
	public void push(E pElem );
	
	
	/**
	 *Obtener el elemento que est� en el tope de la pila, retir�ndolode la estructura de datos - pop
	 *@return elemento eliminado 
	 */
	E pop();
	
	
	/**
	 * Consulta el tama�o del queue
	 * @return int tama�o del queue
	 */
	int size();
	
	
	/**
	 * Verificas si la lista est� vac�a
	 * @return verdadero o falso, dependiendo si est� vac�a o no la cola
	 */
	boolean isEmpty();
	
	

}
