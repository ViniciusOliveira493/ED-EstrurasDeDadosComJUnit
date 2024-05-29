package classes;

public class LinkedList<T> {
	private Node<T> first;
	private Node<T> last;
	private int size = 0;
	
	public boolean add(T element) {
		Node<T> newNode = new Node<T>(element);
		boolean r = false;
		
		if(this.first == null) {
			this.first = newNode;
			this.last = newNode;
			this.size++;
			r = true;
			
		}else {
			this.last.setNext(newNode);
			this.last = newNode;
			this.size++;
			r = true;
		}		
		
		return r;
	}
	
	public boolean add(T element, int position) {
		Node<T> newNode = new Node<T>(element);
		
		if((position == size) || size == 0) {
			if(this.add(element)) {
				return true;
			}
		}
		
		if((position == 0)) {
			Node<T> aux = this.first;
			this.first = newNode;
			this.first.setNext(aux);
			
			size++;
			return true;
		}
		
		if(indexIsValid(position)) {
			Node<T> aux = this.first;
			
			for(int i = 1;i < position;i++) {
				aux = aux.getNext();
			}
			
			Node<T> nodeNext = aux.getNext();
			
			newNode.setNext(nodeNext);
			aux.setNext(newNode);
			
			size++;
			return true;
		}		
		
		return false;
	}
	
	public int getSize() {
		return this.size;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("[ ");
		Node<T> aux = this.first;
		
		while(aux != null) {
			str.append(aux.getElement().toString());
			
			if(aux.getNext() != null) {
				str.append(", ");
			}
			
			aux = aux.getNext(); 
		}
		
		str.append(" ]");
		return str.toString();
	}
	
	private boolean indexIsValid(int index) {
		if((index < 0) || (index > size)) {
			throw new IndexOutOfBoundsException("Invalid Index");
		}
		
		return true;
	}
	
	public void clear() {
		Node<T> aux = first;
		
		while(aux != null) {
			Node<T> next = aux.getNext();
			aux.setElement(null);
			aux.setNext(null);
			aux = next;
			size--;
		}
	}
	 
	public int get(T element) {
		Node<T> aux = first;
		int count = 0;
		
		while(! aux.getElement().equals(element)) {
			aux = aux.getNext();
			count++;
			
			if(aux == null) {
				return -1;
			}
		}
		
		return count;
	}
	
	public T get(int position) {
		Node<T> aux = first;		
		
		for (int i = 0; i < position; i++) {
			aux = aux.getNext();
		}
		
		return aux.getElement();
	}
	
	public T removeFirst() {
		if(this.size > 0) {
			T element = first.getElement();
			Node<T> next = first.getNext();
			
			this.first.setElement(null);
			this.first.setNext(null);
			
			this.first = next;
			this.size--;
			return element;
		}
		
		return null;
	}
	
	public T removeLast() {
		if(this.size == 1) {
			return this.removeFirst();
		}
		
		if(this.size > 1) {
			Node<T> aux = first;
			for (int i = 0; i < this.size - 2; i++) {
				aux = aux.getNext();
			}
			
			Node<T> last = aux.getNext();
			T element = last.getElement();
			last.setElement(null);
			last.setNext(null);
			
			aux.setNext(null);
			this.last = aux;
			this.size--;
			
			return element;
		}
		
		return null;
	}
	
	public T remove(int index) {
		if(index == 0) {
			return this.removeFirst();
		}
		
		if(index == size) {
			return this.removeLast();
		}
		
		if(indexIsValid(index)) {
			Node<T> aux = first;
			for (int i = 0; i < index - 1; i++) {
				aux = aux.getNext();
			}
			
			Node<T> target = aux.getNext();
			T element = target.getElement();
			
			aux.setNext(target.getNext());
			target.setElement(null);
			target.setNext(null);
			
			this.size--;
			
			return element;
		}
		
		return null;
	}
}
