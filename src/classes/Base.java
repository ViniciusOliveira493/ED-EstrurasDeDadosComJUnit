package classes;

public abstract class Base<T> {
	protected T vector[];
	protected int size;
	
	public Base() {
		vector = (T[]) new Object[10];
		size = 0;
	}
	
	protected boolean add(T object) {
		expandVector();
		vector[size] = object;
		size++;
		return true;
	}
	
	//---------- AUX -------------
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("[ ");
		for (int i = 0; i < size; i++) {
			str.append(vector[i]);
			
			if(i != size-1) {
				str.append(", ");
			}
		}
		str.append(" ]");
		
		return str.toString();
	}
	
	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	public int size() {
		return this.size;
	}
	
	public int capacity() {
		return this.vector.length;
	}
	
	protected void expandVector() {
		if(size == capacity()) {
			T[] d = (T[]) new Object[this.capacity() * 2];
			this.vector = copy(this.vector, d);
		}
	}
	
	protected T[] copy(T[] origin,T[] destination) {
		
		for (int i = 0; i < origin.length; i++) {
			destination[i] = origin[i];
		}
		
		return destination;
	}
}
