package Taller1.src.model;

public class Queue {
	public int[] queue;
	public int front, rear, size, nItems;
	
	public Queue (int maxSize){
		size = maxSize;
		queue = new int[size];
		front = -1;
		rear = -1;
		nItems = 0;
	}
	
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
	
	public boolean isEmpty(){
		return nItems == 0;
	}
	
	public boolean isFull(){
		return nItems == size;
	}

    public int peek(){
        if (isEmpty()){
            throw new IllegalStateException("The Queue is empty");
        }
        return queue[front];
    }

	public int size(){
		return nItems;
	}

    public int[] toArray(){
        int[] copy = new int[nItems];
        for(int i = 0; i < nItems; i++){
            copy[i] = queue[(front + i) % size];
        }
        return copy;
    }

}

