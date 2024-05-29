package classes;

public class List<T> extends Base<T> {	
	public List() {
		super();
	}	
	
	public boolean add(T object) {
		return super.add(object);
	}
	
	public boolean add(int index,T object) throws IndexOutOfBoundsException{
		if(checkIndex(index)) {
			size++;
			expandVector();
			
			for (int i = size-2; i >= index; i--) {
				vector[i+1] = vector[i]; 
			}
			
			vector[index] = object;
			return true;
		}
		
		return false;
	}
	
	public T get(int index) throws IndexOutOfBoundsException{		
		if(checkIndex(index)) {
			return vector[index];
		}
		
		return null;
	}
	
	public int indexOf(T object) {
		for (int i = 0; i < size; i++) {
			if(vector[i].equals(object)) {
				return i;
			}
		}
		
		return -1;
	}

	public boolean remove(int index) throws IndexOutOfBoundsException{
		if(checkIndex(index)) {
			for (int i = index; i < size-1; i++) {
				vector[i] = vector[i+1];
			}
			size--;
			return true;
		}
		
		return false;
	}
	
	public boolean remove(T object) throws IndexOutOfBoundsException{
		int i = indexOf(object);
		return remove(i);
	}
	
	protected boolean checkIndex(int index) throws IndexOutOfBoundsException{
		if(index > -1 && index < size){
			return true;
		}
		throw new IndexOutOfBoundsException("invalid index");
	}
}
