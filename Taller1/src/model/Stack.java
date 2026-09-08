package Taller1.src.model;

public class Stack {
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
			throw new IllegalStateException("La pila está llena");
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
			throw new IllegalStateException("La pila está vacía");
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

    public int peek(){
        if(nItems == 0){
            throw new IllegalStateException("The Stack is empty");
        } 
        return stack[top];
    }

    public int[] toArray(){
        int[] copy = new int[nItems];
        for(int i = 0; i < nItems; i++){
            copy[i] = stack[top - i];
        }
        return copy;
    }

}



