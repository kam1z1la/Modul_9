package Task1;

import java.util.Arrays;
import java.util.Random;

class MyArrayList {
    private Object[] array;

    MyArrayList(int size) {
        this.array = new Object[size];
    }

    public void fillNumbers() {
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(10);
        }
    }

    public void fillWords() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            char code = (char) (new Random().nextInt(94) + 33);
            array[i] = string.append(code);
        }
    }

    public Object[] add(Object value) {
        int size = array.length;
        size++;
        Object[] secondArray = Arrays.copyOf(array, size);
        for (int i = array.length; i < size; i++) {
                secondArray[i] = value;
        }
        return array = Arrays.copyOf(secondArray, size);
    }

    public Object[] remove(int index) {
        int size = array.length;
        size--;
        int element = 0;
        Object[] secondArray = new Object[size];
        for (int i = 0; i < size; i++) {
            if (i != index) {
                element++;
                secondArray[i] = array[element];
            } else {
                element++;
                secondArray[i] = array[element];
            }
        }
        return array = Arrays.copyOf(secondArray, size);
    }

    public Object[] clear() {
        Object[] newArray = new Object[0];
        return array = Arrays.copyOf(newArray, newArray.length);
    }

    public int size() {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            count++;
        }
        return count;
    }

    public Object get(int index) {
        Object count = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == index) {
                count = array[i];
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList(5);
        list.fillNumbers();
        list.add(1);
        list.add(1);
        System.out.println(list);

        System.out.print("Remove by index: ");
        list.remove(0);
        System.out.println(list);

        System.out.println("Size: " + list.size());

        System.out.println("Get by index: " + list.get(1));

        System.out.print("Clear: ");
        list.clear();
        System.out.println(list);

        MyArrayList list1 = new MyArrayList(5);
        list1.fillWords();
        System.out.println(list1);

        list1.add("Q");
        list1.add("Z");
        System.out.println(list1);

        System.out.print("Remove by index: ");
        list1.remove(0);
        System.out.println(list1);

        System.out.println("Get by index: " + list1.get(1));
    }
}