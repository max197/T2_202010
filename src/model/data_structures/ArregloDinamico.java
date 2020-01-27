package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico implements IArregloDinamico {
		/**
		 * Capacidad maxima del arreglo
		 */
        private int tamanoMax;
		/**
		 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
		 */
        private int tamanoAct;
        /**
         * Arreglo de elementos de tamaNo maximo
         */
        private String elementos[ ];

        /**
         * Construir un arreglo con la capacidad maxima inicial.
         * @param max Capacidad maxima inicial
         */
		public ArregloDinamico( int max )
        {
               elementos = new String[max];
               tamanoMax = max;
               tamanoAct = 0;
        }
        
		public void agregar( String dato )
        {
               if ( tamanoAct == tamanoMax )
               {  // caso de arreglo lleno (aumentar tamaNo)
                    tamanoMax = 2 * tamanoMax;
                    String [ ] copia = elementos;
                    elementos = new String[tamanoMax];
                    for ( int i = 0; i < tamanoAct; i++)
                    {
                     	 elementos[i] = copia[i];
                    } 
            	    System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
               }	
               elementos[tamanoAct] = dato;
               tamanoAct++;
       }

		public int darCapacidad() {
			return tamanoMax;
		}

		public int darTamano() {
			return tamanoAct;
		}

		public String darElemento(int i) 
		{
			// TODO implementar	
			return elementos[i];
		}

		public String buscar(String dato) {
			// TODO implementar
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			boolean encontro = false;
			int i = 0;
			String aRetornar = null;
			
			while (!encontro & i < elementos.length)
			{
				if (elementos[i] != null)
				{
					if (elementos[i].compareTo(dato) == 0)
					{
						encontro = true;
						aRetornar = elementos[i];
					}
				}
				
				i++;
			}
			return aRetornar;
		}

		public String eliminar(String dato) 
		{
			// TODO implementar
			//Elimino y retorno ese objeto.
			// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
			String buscarDato = buscar(dato);
			if (buscarDato == null)
			{
				return null;
			}
			else
			{
				tamanoAct--;
				boolean encontro = false;
				int i = 0;
				String aEliminar = null;
				
				while (!encontro & i < elementos.length)
				{
					if (elementos[i].compareTo(dato) == 0)
					{
						encontro = true;
						aEliminar = elementos[i];
					}
					i++;
				}
				//Aqui el i ya guardo el indice de donde esta el objeto a eliminar. 
				
				//Aqui si el indice llega al tamanio, entonces es el ultimo elemtno, lo paso a null
				if (i == darTamano())
				{
					elementos[i] = null;
					tamanoAct--;
					return null;
				}
				//Si es el primer elemento o alguno en la mitad hago el ciclo desde i hasta que acabe para ir reemplazando
				else
				{
					while (i < elementos.length)
					{
						elementos[i-1] = elementos[i];
						i++;
					}
					return aEliminar;
				}
				
			}		
		}

}
