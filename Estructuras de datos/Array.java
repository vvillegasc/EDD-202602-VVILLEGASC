class Array {
	private int[] array;
	private int size;
	private int nItems;

	public Array(int maxSize){
		size = maxSize;
		array = new int[size];
		nItems = 0;
	}

	public void insert(int item){
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
	
	public void traverse(){
		for (int i=0; i<nItems; i++){
			System.out.print(array[i]);
			if (i+1 < nItems ) System.out.print(", ");
		}
		System.out.println();
	}

}
