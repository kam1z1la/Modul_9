package Task3;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;

class MyQueue<T> {
    Nodes<T> head;

    int size = 0;

    MyQueue() {
        head = null;
    }

    public void add(T value) {
        Nodes<T> node = new Nodes<>(value);
        Nodes<T> secondNode = head;
        if (head == null) {
            head = node;
        } else {
            while (secondNode.next != null) {
                secondNode = secondNode.next;
            }
            secondNode.next = node;
            size++;
        }
    }

    public void clear() {
        Nodes<T> node = head;
        while (head != null & size != 0) {
            node.next = null;
            node.item = null;
            head = null;
            size--;
        }
    }

    public int size() {
        return size + 1;
    }

    @Override
    public String toString() {
        StringBuilder write = new StringBuilder();
        Nodes<T> node = head;
        if (node == null || node.item == null) {
            return "[]";
        } else while (node != null) {
            write.append(node.item).append(", ");
            node = node.next;
        }
        write.deleteCharAt(write.lastIndexOf(", "));
        String show = write.toString();
        return "[" + show.strip() + "]";
    }

    public Object peek(){
        Nodes<T> node = head;
        if (head != null){
            return  node.item;
        }
        return 0;
    }

    public T poll(){
        Nodes<T> node = head;
        T el = null;

        if(node == null) {
            return null;
        } else {
            while (node != null) {
                if( node == head) {
                    el = node.item;
                    node = node.next;
                    head = node;
                }
                node = node.next;
            }
            if (el == null)
                 throw new NoSuchElementException();
        }
        size--;
        return el;
    }

    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<>();
        queue.add(1);  queue.add(2);  queue.add(3);  queue.add(4);  queue.add(5);
        System.out.println(queue);

        System.out.println("Return first element from queue: " + queue.peek());
        System.out.println("Remove first element from queue: " + queue.poll());
        System.out.println(queue);

        System.out.println("Remove first element from queue: " + queue.poll());
        System.out.println(queue);
        System.out.println("Size queue: " + queue.size());
        System.out.print("Clear queue: ");
        queue.clear();
        System.out.println(queue);
        queue.add(1);
        System.out.println(queue);

        MyQueue<String> queue1 = new MyQueue<>();
        queue1.add("A");  queue1.add("B");  queue1.add("C");  queue1.add("D");
        System.out.println(queue1);

        System.out.println("Return first element from queue: " + queue1.peek());
        System.out.println("Remove first element from queue: " + queue1.poll());
        System.out.println(queue1);
        System.out.print("Clear queue: ");
        queue1.clear();
        System.out.println(queue1);

        Queue<Integer> queue2 = new ArrayDeque<>();
        queue2.peek();
        queue2.poll();
        queue2.size();
    }
}