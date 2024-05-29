package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import classes.Stack;

class StackTest {

	@Test
	void createStack_TS001() {
		Stack<String> stack = new Stack<>();
		assertEquals(0, stack.size());
		assertEquals(10, stack.capacity());
	}
	
	@Test
	void pushElement_TS002() {
		Stack<String> stack = new Stack<>();
		stack.push("A");
		
		assertEquals(1, stack.size());
		assertEquals("[ A ]", stack.toString());
	}
	
	@Test
	void pushMultipleElements_TS003() {
		Stack<String> stack = new Stack<>();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		assertEquals(3, stack.size());
		assertEquals("[ A, B, C ]", stack.toString());
	}
	
	@Test
	void peekElement_TS004() {
		Stack<String> stack = new Stack<>();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		assertEquals(3, stack.size());
		assertEquals("C", stack.peek());
		assertEquals("[ A, B, C ]", stack.toString());
	}
	
	@Test
	void popElement_TS005() {
		Stack<String> stack = new Stack<>();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		
		assertEquals(3, stack.size());
		assertEquals("[ A, B, C ]", stack.toString());
		assertEquals("C", stack.pop());
		assertEquals(2, stack.size());
		assertEquals("[ A, B ]", stack.toString());	
	}
	
	@Test
	void tryingToPeekAndPopElementWhenEmpty_TS006() {
		Stack<String> stack = new Stack<>();
		
		assertNull(stack.peek());
		assertNull(stack.pop());
	}

}
