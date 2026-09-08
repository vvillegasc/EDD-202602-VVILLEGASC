class Stack {
	private int[] stack;
	private int top, size, nItems;

	public Stack(int maxSize){
		size = maxSize;
		stack = new int[size];
		top = -1;
		nItems = 0;
	}

	public void push(int value){
		if (nItems == size){
			System.out.println("The Stack is full");
			return;
		}

		top++;
		stack[top] = value;
		nItems++;
	}

	public int len(){
		return nItems;
	}

	public int pop(){
		if (nItems == 0){
			System.out.println("The Stack is empty");
			return -1;
		}
		int item = stack[top];
		stack[top] = 0;
		nItems--;
		top--;
		return item;
	}

	public boolean isEmpty(){
		return nItems == 0;
	}

	public boolean isFull(){
		return nItems == size;
	}

	public void traverse(){
		for (int i=0; i<size; i++){
			System.out.println(stack[size-i-1]);
		}
		System.out.println();
	}

}



