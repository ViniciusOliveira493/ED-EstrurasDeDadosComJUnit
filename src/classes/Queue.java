package classes;

public class Queue<T> extends Base<T> {
	public final int START_LIMIT = 100;
	private int start = 0; 
	
	public boolean enqueue(T object) {
		return super.add(object);
	}
	
	public T peek() {
		if(!this.isEmpty()) {
			return this.vector[start];
		}
		
		return null;
	}
	
	public T dequeue() {
		if(!this.isEmpty()) {
			T aux = this.vector[start];
			start++;			
			clearList();		
			return aux;
		}
		
		return null;
	}
	
	private void clearList() {
		if(start > START_LIMIT) {
			this.size = this.size - (this.start);		
			this.vector = copy(this.vector,start);
			start = 0;
		}
	}
	
	private T[] copy(T[] origin,int startPosition) {
		T aux[] = (T[]) new Object[vector.length];
		
		for(int i = startPosition; i < origin.length; i++) {
			aux[i-(START_LIMIT+1)] = origin[i];
		}
		
		return aux;
	}
	
	@Override
	public int size() {
		return this.size - this.start;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("[ ");
		for (int i = start; i < size; i++) {
			str.append(vector[i]);
			
			if(i != size-1) {
				str.append(", ");
			}
		}
		str.append(" ]");
		
		return str.toString();
	}
	
}
