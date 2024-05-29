package testes;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import classes.LinkedList;

class LinkedListTest {

	@Test
	void createLinkedList_TLL001() {
		LinkedList<String> list = new LinkedList<String>();
		assertEquals(0, list.getSize());
	}
	
	@Test
	void add1ElementToList_TLL002() {
		LinkedList<String> list = new LinkedList<String>();
		assertTrue(list.add("Elemento 1"));
		assertEquals("[ Elemento 1 ]",list.toString());
		assertEquals(1, list.getSize());
	}
	
	@Test
	void addMultipleElementsToList_TLL003() {
		LinkedList<String> list = new LinkedList<String>();
		assertTrue(list.add("Elemento 1"));
		assertTrue(list.add("Elemento 2"));
		assertTrue(list.add("Elemento 3"));
		assertTrue(list.add("Elemento 4"));
		assertTrue(list.add("Elemento 5"));
		assertTrue(list.add("Elemento 6"));
		
		assertEquals(6, list.getSize());
		assertEquals("[ Elemento 1, Elemento 2, Elemento 3, Elemento 4, Elemento 5, Elemento 6 ]", list.toString());
	}
	
	@Test
	void addElementsToAPositionList_TLL004() {
		LinkedList<String> list = new LinkedList<String>();
		assertTrue(list.add("Elemento 1"));
		assertTrue(list.add("Elemento 2"));
		assertTrue(list.add("Elemento 3"));
		assertTrue(list.add("Elemento 4"));
		assertTrue(list.add("Elemento 5"));
		assertTrue(list.add("Elemento 6"));
		
		assertTrue(list.add("Elemento 2.5", 2));
		assertTrue(list.add("Elemento 2.7", 3));
		
		assertEquals(8, list.getSize());
		assertEquals("[ Elemento 1, Elemento 2, Elemento 2.5, Elemento 2.7, Elemento 3, Elemento 4, Elemento 5, Elemento 6 ]", list.toString());
	}
	
	@Test
	void addElementsToPosition0List_TLL005() {
		LinkedList<String> list = new LinkedList<String>();
		assertTrue(list.add("Elemento 1"));
		assertTrue(list.add("Elemento 2"));
		assertTrue(list.add("Elemento 3"));
		assertTrue(list.add("Elemento 4"));
		assertTrue(list.add("Elemento 5"));
		assertTrue(list.add("Elemento 6"));
		
		assertTrue(list.add("Elemento 0.7", 0));
		assertTrue(list.add("Elemento 0.5", 0));
		assertEquals(8, list.getSize());
		assertEquals("[ Elemento 0.5, Elemento 0.7, Elemento 1, Elemento 2, Elemento 3, Elemento 4, Elemento 5, Elemento 6 ]", list.toString());
	}
	
	@Test
	void addElementsToLastPositionList_TLL006() {
		LinkedList<String> list = new LinkedList<String>();
		assertTrue(list.add("Elemento 1"));
		assertTrue(list.add("Elemento 2"));
		assertTrue(list.add("Elemento 3"));
		assertTrue(list.add("Elemento 4"));
		assertTrue(list.add("Elemento 5"));
		assertTrue(list.add("Elemento 6"));
		
		assertTrue(list.add("Elemento 7", 6));
		assertTrue(list.add("Elemento 8", 7));
		
		assertEquals("[ Elemento 1, Elemento 2, Elemento 3, Elemento 4, Elemento 5, Elemento 6, Elemento 7, Elemento 8 ]", list.toString());
		assertEquals(8, list.getSize());
	}
	
	@Test
	void addElementToAInvalidPosition_TLL007() {
		LinkedList<String> list = new LinkedList<String>();
		assertTrue(list.add("Elemento 1"));
		assertTrue(list.add("Elemento 2"));
		assertTrue(list.add("Elemento 3"));
		assertTrue(list.add("Elemento 4"));
		assertTrue(list.add("Elemento 5"));
		assertTrue(list.add("Elemento 6"));
		
		try {
			list.add("invalid",9);
		} catch (Exception e) {
			assertEquals("Invalid Index", e.getMessage());
		}
		assertEquals(6, list.getSize());
		assertEquals("[ Elemento 1, Elemento 2, Elemento 3, Elemento 4, Elemento 5, Elemento 6 ]", list.toString());
	}
	
	@Test
	void clearList_TLL008() {
		LinkedList<String> list = new LinkedList<String>();
		assertTrue(list.add("Elemento 1"));
		assertTrue(list.add("Elemento 2"));
		assertTrue(list.add("Elemento 3"));
		assertTrue(list.add("Elemento 4"));
		assertTrue(list.add("Elemento 5"));
		assertTrue(list.add("Elemento 6"));
		
		list.clear();
		assertEquals(0, list.getSize());
	}
	
	@Test
	void getIndex_TLL009() {
		LinkedList<String> list = new LinkedList<String>();
		assertTrue(list.add("Elemento 1"));
		assertTrue(list.add("Elemento 2"));
		assertTrue(list.add("Elemento 3"));
		assertTrue(list.add("Elemento 4"));
		assertTrue(list.add("Elemento 5"));
		assertTrue(list.add("Elemento 6"));
		
		assertEquals(1,list.get("Elemento 2"));
	}
	
	@Test
	void getInvalidIndex_TLL010() {
		LinkedList<String> list = new LinkedList<String>();
		assertTrue(list.add("Elemento 1"));
		assertTrue(list.add("Elemento 2"));
		assertTrue(list.add("Elemento 3"));
		assertTrue(list.add("Elemento 4"));
		assertTrue(list.add("Elemento 5"));
		assertTrue(list.add("Elemento 6"));
		
		assertEquals(-1,list.get("Elemento 7"));
	}
	
	@Test
	void getElement_TLL011() {
		LinkedList<String> list = new LinkedList<String>();
		assertTrue(list.add("Elemento 1"));
		assertTrue(list.add("Elemento 2"));
		assertTrue(list.add("Elemento 3"));
		assertTrue(list.add("Elemento 4"));
		assertTrue(list.add("Elemento 5"));
		assertTrue(list.add("Elemento 6"));
		
		assertEquals("Elemento 1",list.get(0));
		assertEquals("Elemento 2",list.get(1));
		assertEquals("Elemento 3",list.get(2));
		assertEquals("Elemento 4",list.get(3));
		assertEquals("Elemento 5",list.get(4));
		assertEquals("Elemento 6",list.get(5));
	}
	
	@Test
	void removeFirstElement_TLL012() {
		LinkedList<String> list = new LinkedList<String>();
		assertTrue(list.add("Elemento 1"));
		assertTrue(list.add("Elemento 2"));
		assertTrue(list.add("Elemento 3"));
		assertTrue(list.add("Elemento 4"));
		assertTrue(list.add("Elemento 5"));
		assertTrue(list.add("Elemento 6"));
		
		assertEquals("Elemento 1", list.removeFirst());
		assertEquals(5, list.getSize());
		assertEquals("[ Elemento 2, Elemento 3, Elemento 4, Elemento 5, Elemento 6 ]", list.toString());
	}
	
	@Test
	void removeLastElement_TLL013() {
		LinkedList<String> list = new LinkedList<String>();
		assertTrue(list.add("Elemento 1"));
		assertTrue(list.add("Elemento 2"));
		assertTrue(list.add("Elemento 3"));
		assertTrue(list.add("Elemento 4"));
		assertTrue(list.add("Elemento 5"));
		assertTrue(list.add("Elemento 6"));
		
		assertEquals("Elemento 6", list.removeLast());
		assertEquals(5, list.getSize());
		assertEquals("[ Elemento 1, Elemento 2, Elemento 3, Elemento 4, Elemento 5 ]", list.toString());
	}
	
	@Test
	void removeFirstElementOnEmptyList_TLL014() {
		LinkedList<String> list = new LinkedList<String>();
		
		assertEquals(null, list.removeFirst());
		assertEquals(0, list.getSize());
		assertEquals("[  ]", list.toString());
	}
	
	@Test
	void removeLastElementOnEmptyList_TLL015() {
		LinkedList<String> list = new LinkedList<String>();
		
		assertEquals(null, list.removeLast());
		assertEquals(0, list.getSize());
		assertEquals("[  ]", list.toString());
	}
	
	@Test
	void removeFirstElementOnListWith1item_TLL016() {
		LinkedList<String> list = new LinkedList<String>();
		assertTrue(list.add("Elemento 1"));
		assertEquals("[ Elemento 1 ]", list.toString());
		
		assertEquals("Elemento 1", list.removeFirst());
		assertEquals(0, list.getSize());
		assertEquals("[  ]", list.toString());
	}
	
	@Test
	void removeLastElementOnListWith1item_TLL017() {
		LinkedList<String> list = new LinkedList<String>();
		assertTrue(list.add("Elemento 1"));
		assertEquals("[ Elemento 1 ]", list.toString());
		
		assertEquals("Elemento 1", list.removeLast());
		assertEquals(0, list.getSize());
		assertEquals("[  ]", list.toString());
	}
	
	@Test
	void removeElementByIndex_TLL018() {
		LinkedList<String> list = new LinkedList<String>();
		assertTrue(list.add("Elemento 1"));
		assertTrue(list.add("Elemento 2"));
		assertTrue(list.add("Elemento 3"));
		assertTrue(list.add("Elemento 4"));
		assertTrue(list.add("Elemento 5"));
		assertTrue(list.add("Elemento 6"));
		
		assertEquals("Elemento 3", list.remove(2));
		assertEquals(5, list.getSize());
		assertEquals("[ Elemento 1, Elemento 2, Elemento 4, Elemento 5, Elemento 6 ]", list.toString());
		
		assertEquals("Elemento 1", list.remove(0));
		assertEquals(4, list.getSize());
		assertEquals("[ Elemento 2, Elemento 4, Elemento 5, Elemento 6 ]", list.toString());
		
		assertEquals("Elemento 6", list.remove(4));
		assertEquals(3, list.getSize());
		assertEquals("[ Elemento 2, Elemento 4, Elemento 5 ]", list.toString());
	}
	
	@Test
	void removeElementFromInvalidIndex_TLL019() {
		LinkedList<String> list = new LinkedList<String>();
		assertTrue(list.add("Elemento 1"));
		assertTrue(list.add("Elemento 2"));
		assertTrue(list.add("Elemento 3"));
		assertTrue(list.add("Elemento 4"));
		assertTrue(list.add("Elemento 5"));
		assertTrue(list.add("Elemento 6"));
		
		try {
			list.remove(10);
		} catch (Exception e) {
			assertEquals("Invalid Index", e.getMessage());
		}
		
		assertEquals(6, list.getSize());
		assertEquals("[ Elemento 1, Elemento 2, Elemento 3, Elemento 4, Elemento 5, Elemento 6 ]", list.toString());
	}
	
	@Test
	void addElementToInvalidIndex_TLL020() {
		LinkedList<String> list = new LinkedList<String>();
		assertTrue(list.add("Elemento 1"));
		assertTrue(list.add("Elemento 2"));
		assertTrue(list.add("Elemento 3"));
		assertTrue(list.add("Elemento 4"));
		assertTrue(list.add("Elemento 5"));
		assertTrue(list.add("Elemento 6"));
		
		try {
			list.add("Invalid",10);
		} catch (Exception e) {
			assertEquals("Invalid Index", e.getMessage());
		}
		
		assertEquals(6, list.getSize());
		assertEquals("[ Elemento 1, Elemento 2, Elemento 3, Elemento 4, Elemento 5, Elemento 6 ]", list.toString());
	}

}
