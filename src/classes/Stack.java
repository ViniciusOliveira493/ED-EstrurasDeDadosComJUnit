package classes;

public class Stack<T> extends Base<T>{
	public Stack() {
		super();
	}
	
	public boolean push(T object) {
		return super.add(object);
	}
	
	public T peek() {
		if(!this.isEmpty()) {
			return this.vector[this.size()-1];
		}
		return null;
	}
	
	
	public T pop() {
		if(!this.isEmpty()){
			T aux = this.vector[this.size()-1];
			this.size--;
			return aux;
		}
		return null;
	}
	
}
