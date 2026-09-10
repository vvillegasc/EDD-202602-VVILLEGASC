package model;

/**
 * Pila (LIFO) de enteros de tamaño fijo (estructura vista en clase).
 *
 * <p>Es un <b>modelo</b> del patrón MVC: no imprime ni lee por consola.
 * Las operaciones inválidas (pila llena o vacía) lanzan una excepción.</p>
 */
public class Stack {
	/** Almacenamiento interno; su longitud es la capacidad máxima. */
	private int[] stack;
	/**
	 * {@code top}: índice de la cima (-1 si la pila está vacía);
	 * {@code size}: capacidad máxima;
	 * {@code nItems}: cantidad de elementos apilados.
	 */
	private int top, size, nItems;

	/**
	 * Crea una pila vacía con capacidad para {@code maxSize} elementos.
	 *
	 * @param maxSize capacidad máxima de la pila
	 */
	public Stack(int maxSize){
		size = maxSize;
		stack = new int[size];
		top = -1;
		nItems = 0;
	}

	/**
	 * Apila un valor en la cima.
	 *
	 * @param value valor a apilar
	 * @throws IllegalStateException si la pila está llena
	 */
	public void push(int value){
		if (nItems == size){
			throw new IllegalStateException("La pila está llena");
		}

		top++;
		stack[top] = value;
		nItems++;
	}

	/**
	 * Cantidad de elementos actualmente en la pila.
	 *
	 * @return número de elementos apilados
	 */
	public int len(){
		return nItems;
	}

	/**
	 * Desapila y devuelve el valor de la cima.
	 *
	 * @return el valor que estaba en la cima
	 * @throws IllegalStateException si la pila está vacía
	 */
	public int pop(){
		if (nItems == 0){
			throw new IllegalStateException("La pila está vacía");
		}
		int item = stack[top];
		stack[top] = 0;
		nItems--;
		top--;
		return item;
	}

	/**
	 * Indica si la pila no tiene elementos.
	 *
	 * @return {@code true} si está vacía
	 */
	public boolean isEmpty(){
		return nItems == 0;
	}

	/**
	 * Indica si la pila alcanzó su capacidad máxima.
	 *
	 * @return {@code true} si está llena
	 */
	public boolean isFull(){
		return nItems == size;
	}

    /**
     * Consulta el valor de la cima sin desapilarlo.
     *
     * @return el valor en la cima
     * @throws IllegalStateException si la pila está vacía
     */
    public int peek(){
        if(nItems == 0){
            throw new IllegalStateException("The Stack is empty");
        }
        return stack[top];
    }

    /**
     * Devuelve una copia con los elementos reales, ordenados desde la cima
     * hacia la base, sin imprimir nada. Permite que la vista muestre el
     * contenido sin romper MVC.
     *
     * @return copia de longitud {@code nItems} (posición 0 = cima)
     */
    public int[] toArray(){
        int[] copy = new int[nItems];
        for(int i = 0; i < nItems; i++){
            copy[i] = stack[top - i];
        }
        return copy;
    }

}
