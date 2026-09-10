package model;

public class Array {
	private int[] array;
	private int size;
	private int nItems;

	public Array(int maxSize){
		size = maxSize;
		array = new int[size];
		nItems = 0;
	}

	public void insert(int item){
        if(nItems == size){
            throw new IllegalStateException("Array is full");
        }
		int i = nItems;
		array[i] = item;
		nItems++;
		return;
	}

	public int find(int item){
		for (int i=0; i<nItems; i++){
			if (array[i] == item) return i;
		}
		return -1;
	}

    public void deleteByPosition(int position){
        if(position < 0 || position >= nItems){
            throw new IndexOutOfBoundsException("Invalid position: " + position);
        }
        for(int i = position; i<nItems-1; i++){
            array[i] = array[i+1];
        }
        nItems--;
    }

    public int getMax(){
        if(nItems ==0){
            throw new IllegalStateException("Array is empty");
        }
        int max = array[0];
        for (int i = 1; i< nItems;i++){
            if(array[i]>max){
                max=array[i];
            }
        }  
        return max;
    }

    /**
     * Devuelve una copia con solo los elementos reales (sin imprimir).
     * Reemplaza a traverse() para respetar MVC: la Vista se encarga de mostrar.
     */
    public int[] toArray(){
        int[] copy = new int[nItems];
        for(int i = 0; i < nItems; i++){
            copy[i] = array[i];
        }
        return copy;
    }


}

