package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import classes.List;

class ListTest {
	
	@Test	
	public void createList_TL001() {
		List<String> l = new List<String>();
		
		assertEquals(0, l.size());
		assertEquals(10, l.capacity());
	}
	
	@Test
	public void addElement_TL002() {
		List<String> l = new List<String>();
		l.add("A");
		
		assertEquals(1, l.size());
		assertEquals("A", l.get(0));
	}
	
	@Test
	public void addMultipleElements_TL003() {
		List<String> l = new List<String>();
		
		for (int i = 0; i < 15; i++) {
			l.add("A"+i);
		}
		
		//Testando o comportamento da classe base de aumentar a
		//capacidade do vetor ao adicionar mais de 10 elementos
		assertEquals(20, l.capacity());
		
		for (int i = 0; i < 15; i++) {
			assertEquals("A"+i, l.get(i));
		}
	}
	
	@Test
	public void getIndex_TL004() {
		List<String> l = new List<String>();
		l.add("A");
		l.add("B");
		l.add("C");
		l.add("D");
		l.add("E");
		
		assertEquals(0, l.indexOf("A"));
		assertEquals(3, l.indexOf("D"));
		assertEquals(-1, l.indexOf("F"));
	}
	
	@Test
	public void removeIndex_TL005() {
		List<String> l = new List<String>();
		l.add("A");
		l.add("B");
		l.add("C");
		l.add("D");
		l.add("E");

		l.remove(1);
		
		assertEquals(4, l.size());
	}
	
	@Test
	public void removeElement_TL006() {
		List<String> l = new List<String>();
		l.add("A");
		l.add("B");
		l.add("C");
		l.add("D");
		l.add("E");

		l.remove("C");
		
		assertEquals(4, l.size());
		assertEquals(-1, l.indexOf("C"));
	}
	
	@Test
	public void addToIndex_TL007() {
		List<String> l = new List<String>();
		l.add("A");
		l.add("C");
		l.add("D");
		l.add("E");
		l.add("F");

		l.add(1, "B");
		
		assertEquals(6, l.size());
		assertEquals(1, l.indexOf("B"));
	}
	
	@Test
	public void tryingToGetAnInvalidIndex_TL008() {
		List<String> l = new List<String>();
		l.add("A");
		l.add("B");
		l.add("C");
		l.add("D");
		l.add("E");
		
		try {
			l.get(10);
		} catch (Exception e) {
			assertEquals("invalid index", e.getMessage());
		}		
	}
	
	@Test
	public void tryingToGetAnIndexWithAnEmptyList_TL009() {
		List<String> l = new List<String>();
		try {
			l.get(1);
		}catch (Exception e) {
			assertEquals("invalid index", e.getMessage());
			assertEquals(true,l.isEmpty());
		}
	}
	
	@Test
	public void tryingToRemoveAnInvalidIndex_TL010() {
		List<String> l = new List<String>();
		try {
			l.remove(10);
		}catch (Exception e) {
			assertEquals("invalid index", e.getMessage());
			assertEquals(true,l.isEmpty());
		}
	}
}
