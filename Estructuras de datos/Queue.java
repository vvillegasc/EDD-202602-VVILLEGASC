class Queue {
	public int[] queue;
	public int front, rear, size, nItems;
	
	public Queue (int maxSize){
		size = maxSize;
		queue = new int[size];
		front = -1;
		rear = -1; //último dígito
		nItems = 0;
	}
	
	public void enqueue(int value){
		if (isFull()){
			System.out.println("The Queue is full");
			return;
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
			System.out.println("The Queue is empty");
			return -1;
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

	/* public boolean seek(){
		return queue[front];
	}

	public void traverse(){
		for (int i=0; i<size; i++){
			System.out.print(queue[size-i-1]);
		}
		System.out.println();
	}
	*/
}

