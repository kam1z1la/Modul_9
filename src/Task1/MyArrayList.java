package Task1;

import java.util.ArrayList;
import java.util.Arrays;

class MyArrayList<T> {
    private Object[] array;

    MyArrayList() {
        array = new Object[0];
    }

    public Object[] add(T value) {
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

    public void clear() {
        array = new Object[0];
    }

    public int size() {
        return array.length;
    }

    public Object get(int index) {
        for (int i = 0; i < array.length; i++) {
            if (i == index) {
                return array[i];
            }
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println(list);

        System.out.print("Remove by index: ");
        list.remove(0);
        System.out.println(list);

        System.out.println("Size: " + list.size());

        System.out.println("Get by index: ");
        list.get(2);

        System.out.print("Clear: ");
        list.clear();
        System.out.println(list);

        System.out.println("Size " + list.size());

        MyArrayList<String> list1 = new MyArrayList<>();
        list1.add("Q");
        list1.add("Z");
        System.out.println(list1);

        System.out.print("Remove by index: ");
        list1.remove(0);
        System.out.println(list1);

        System.out.println("Get by index: ");
        list1.get(1);
    }
}