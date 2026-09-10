package model;

/**
 * Cola circular (FIFO) de enteros de tamaño fijo (estructura vista en clase).
 *
 * <p>Es un <b>modelo</b> del patrón MVC: no imprime ni lee por consola.
 * Al llenarse reutiliza las posiciones que quedaron libres al frente
 * (comportamiento circular). Las operaciones inválidas lanzan excepción.</p>
 */
public class Queue {
	/** Almacenamiento interno; su longitud es la capacidad máxima. */
	private int[] queue;
	/**
	 * {@code front}: índice del primer elemento (-1 si la cola está vacía);
	 * {@code rear}: índice del último elemento;
	 * {@code size}: capacidad máxima;
	 * {@code nItems}: cantidad de elementos en la cola.
	 */
	private int front, rear, size, nItems;

	/**
	 * Crea una cola vacía con capacidad para {@code maxSize} elementos.
	 *
	 * @param maxSize capacidad máxima de la cola
	 */
	public Queue (int maxSize){
		size = maxSize;
		queue = new int[size];
		front = -1;
		rear = -1;
		nItems = 0;
	}

	/**
	 * Encola un valor al final. Si {@code rear} llegó al final del arreglo,
	 * vuelve al inicio (circular).
	 *
	 * @param value valor a encolar
	 * @throws IllegalStateException si la cola está llena
	 */
	public void enqueue(int value){
		if (isFull()){
			throw new IllegalStateException("La cola está llena");
		}

		if (rear == size - 1){
			rear = -1;
		}

		rear++;
		queue[rear] = value;
		nItems++;
		if (front == -1)
			front++;
	}

	/**
	 * Saca y devuelve el primer elemento de la cola; {@code front} avanza
	 * de forma circular.
	 *
	 * @return el valor que estaba al frente
	 * @throws IllegalStateException si la cola está vacía
	 */
	public int dequeue(){
		if (isEmpty()){
			throw new IllegalStateException("La cola está vacía");
		}
		int value = queue[front];
		queue[front] = 0;
		nItems--;
		front = (front+1) % size;
		return value;
	}

	/**
	 * Indica si la cola no tiene elementos.
	 *
	 * @return {@code true} si está vacía
	 */
	public boolean isEmpty(){
		return nItems == 0;
	}

	/**
	 * Indica si la cola alcanzó su capacidad máxima.
	 *
	 * @return {@code true} si está llena
	 */
	public boolean isFull(){
		return nItems == size;
	}

    /**
     * Consulta el primer elemento de la cola sin sacarlo.
     *
     * @return el valor al frente
     * @throws IllegalStateException si la cola está vacía
     */
    public int peek(){
        if (isEmpty()){
            throw new IllegalStateException("The Queue is empty");
        }
        return queue[front];
    }

	/**
	 * Cantidad de elementos actualmente en la cola.
	 *
	 * @return número de elementos
	 */
	public int size(){
		return nItems;
	}

    /**
     * Devuelve una copia con los elementos reales, en orden desde el frente
     * hacia el final, recorriendo de forma circular y sin imprimir nada.
     *
     * @return copia de longitud {@code nItems} (posición 0 = frente)
     */
    public int[] toArray(){
        int[] copy = new int[nItems];
        for(int i = 0; i < nItems; i++){
            copy[i] = queue[(front + i) % size];
        }
        return copy;
    }

}
