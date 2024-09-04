import java.util.LinkedList;
import java.util.Queue;

public class postfixevluation<T> {
    private Queue<T> queue1;
    private Queue<T> queue2;

    public postfixevluation() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // Push operation
    public void push(T data) {
        queue2.add(data);

        // Move all elements from queue1 to queue2
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }

        // Swap the names of queue1 and queue2
        Queue<T> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // Pop operation
    public T pop() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue1.remove();
    }

    // Peek operation
    public T peek() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue1.peek();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }
    
    public static void main(String[] args) {
        postfixevluation<Integer> stack = new postfixevluation<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element is: " + stack.peek()); // Should print 30
        System.out.println("Popped element is: " + stack.pop()); // Should print 30
        System.out.println("Top element is: " + stack.peek()); // Should print 20
    }
}