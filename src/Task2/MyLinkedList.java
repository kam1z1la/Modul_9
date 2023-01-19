package Task2;

class MyLinkedList<T> {
    Nodes<T> head;

    int counter = 0;

    MyLinkedList() {
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
            counter++;
        }
    }

    public T get(int index) {
        Nodes<T> node = head;
        int step = 0;
        while (head != null) {
            if (index == step & step <= counter) {
                return node.item;
            }
            node = node.next;
            step++;
        }
        throw new IndexOutOfBoundsException();
    }

    public T remove(int index) {
        Nodes<T> node = head;
        Nodes<T> nextNode = null;
        T el = null;

        int step = 0;
        while (node != null) {
            if (index == step) {
                if (node == head) {
                    el = node.item;
                    node = node.next;
                    head = node;
                } else {
                    nextNode.next = node.next;
                    el = node.item;
                }
            }
            nextNode = node;
            node = node.next;
            step++;
        }

        if( el == null)
            throw new IndexOutOfBoundsException();

        counter--;
        return el;
    }

    @Override
    public String toString() {
        StringBuilder write = new StringBuilder();
        Nodes<T> node = head;
        if (node == null) {
            write.append("Head null");
        } else while (node != null) {
            write.append(node.item).append("\t");
            node = node.next;
        }
        return write.toString();
    }

    public int size() {
        return counter != 0?counter + 1: 1;
    }

    public void clear() {
        Nodes<T> node = head;
        while (head != null & counter != 0) {
            node.next = null;
            node.item = null;
            head = null;
            counter--;
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        System.out.println("Size: " + list.size());

        System.out.println("Get by index: " + list.get(0));

        System.out.println("Remove by index: " + list.remove(2));
        System.out.println(list);

        System.out.print("Clear: ");
        list.clear();
        System.out.println(list);

        MyLinkedList<String> list1 = new MyLinkedList<>();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        System.out.println(list1);

        System.out.println("Remove by index: " + list1.remove(2));
        System.out.println(list1);

        System.out.print("Clear: ");
        list1.clear();

        System.out.println("Size: " + list1.size());
    }
}