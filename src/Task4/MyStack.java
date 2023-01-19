package Task4;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class MyStack<T> {

    Object[] array;

    MyStack() {
        array = new Object[0];
    }

    public Object[] push(T value) {
        int size = array.length;
        size++;
        Object[] secondArray = Arrays.copyOf(array, size);
        for (int i = array.length; i < size; i++) {
            secondArray[i] = value;
        }
        return array = secondArray;
    }


    public Object[] remove(int index) {
        int size = array.length;
        size--;
        int element = 0;
        Object[] secondArray = new Object[size];
        for (int i = 0; i < size; i++) {
            if (i == index) {
                element++;
            }
            secondArray[i] = array[element];
            element++;
        }
        return array = secondArray;
    }

    public Object[] clear() {
        if (array.length != 0)
            return new Object[0];
        else throw new UnsupportedOperationException();
    }

    public int size() {
        return array.length;
    }

    public Object peek() {
        for (Object o : array) {
            return o;
        }
        return null;
    }

    public Object pop() {
        Object el = null;
        for (Object o : array) {
            el = o;
            break;
        }
        remove(0);
        return el;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        System.out.println(stack);
        System.out.println("Remove by index from stack: ");
        stack.remove(1);
        System.out.println(stack);
        System.out.println("Get first element from stack: " + stack.peek());

        System.out.println("Remove by index from stack: ");
        stack.remove(0);
        System.out.println(stack);
        System.out.println(stack.peek());

        System.out.println("Get first element and remove from stack: " + stack.pop());
        System.out.println(stack);

        System.out.println("Size: " + stack.size());
//        System.out.println("Clear " + Arrays.toString(stack.clear()));

        MyStack<String> stack1 = new MyStack<>();
        stack1.push("A");
        stack1.push("B");
        stack1.push("D");
        stack1.push("C");

        System.out.println("Remove by index from stack: ");
        stack1.remove(1);
        System.out.println(stack1);
        System.out.println("Get first element from stack: " + stack1.peek());
//        System.out.println("Clear " + Arrays.toString(stack.clear()));

        Deque<Integer> deque = new ArrayDeque<>();
        deque.clear();
        deque.peek();
        deque.poll();
    }
}
