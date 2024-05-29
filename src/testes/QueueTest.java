package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import classes.Queue;

class QueueTest {

	@Test
	void createQueue_TQ001() {
		Queue<String> q = new Queue<String>();
		assertEquals(0, q.size());
		assertEquals(10, q.capacity());
	}
	
	@Test
	void addElementToQueue_TQ002() {
		Queue<String> q = new Queue<String>();
		q.enqueue("A");
		assertEquals("[ A ]", q.toString());
		assertEquals(1,q.size());
		assertEquals("A", q.dequeue());
	}
	
	@Test
	void addMultiplesElementsToQueue_TQ002() {
		Queue<String> q = new Queue<String>();
		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("C");
		q.enqueue("D");
		q.enqueue("E");
		
		assertEquals("[ A, B, C, D, E ]", q.toString());
		assertEquals(5,q.size());
	}
	
	@Test
	void peekElementFromQueue_TQ003() {
		Queue<String> q = new Queue<String>();
		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("C");
		q.enqueue("D");
		q.enqueue("E");
		
		assertEquals("A", q.peek());
		assertEquals(5, q.size());
	}
	
	@Test
	void dequeue1ElementFromQueue_TQ004() {
		Queue<String> q = new Queue<String>();
		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("C");
		q.enqueue("D");
		q.enqueue("E");
		
		assertEquals("A", q.dequeue());
		assertEquals("[ B, C, D, E ]", q.toString());
		assertEquals(4, q.size());
	}
	
	@Test
	void dequeue2ElementsFromQueue_TQ005() {
		Queue<String> q = new Queue<String>();
		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("C");
		q.enqueue("D");
		q.enqueue("E");
		
		assertEquals("A", q.dequeue());
		assertEquals("[ B, C, D, E ]", q.toString());
		
		assertEquals("B", q.dequeue());
		assertEquals("[ C, D, E ]", q.toString());
		
		assertEquals(3, q.size());
	}
	
	@Test
	void enqueueAndDequeueMoreElementsThanLimit_TQ006() {
		Queue<String> q = new Queue<String>();
		
		for(int i=0;i<q.START_LIMIT+10;i++) {
			q.enqueue("A"+i);
		}
		
		assertEquals(q.START_LIMIT+10,q.size());
		
		for(int i=0;i<q.START_LIMIT+10;i++) {
			assertEquals("A"+i, q.dequeue());		
			assertEquals((q.START_LIMIT+9)-i,q.size());	
		}
		
		assertEquals(0,q.size());
	}
	
	@Test
	void tryingToPeekAndDequeueWhenEmpty_TQ007() {
		Queue<String> q = new Queue<String>();
		assertEquals(0, q.size());
		assertEquals(true, q.isEmpty());
		
		assertNull(q.peek());
		assertNull(q.dequeue());
	}
	
	@Test
	void dequeuePositionGreaterThanSize_TQ008() {
		Queue<String> q = new Queue<String>();
		
		for(int i=0;i<q.START_LIMIT+10;i++) {
			q.enqueue("A"+i);
		}
		
		assertEquals(q.START_LIMIT+10,q.size());
		
		for(int i=0;i<q.START_LIMIT+15;i++) {
			if(i<q.START_LIMIT+10) {
				assertEquals("A"+i, q.dequeue());		
				assertEquals((q.START_LIMIT+9)-i,q.size());
			}else {
				assertNull(q.dequeue());
			}
		}
		
		assertEquals(0,q.size());
		
	}

}
