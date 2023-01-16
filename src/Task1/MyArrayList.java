package Task1;

import java.util.Arrays;
import java.util.Random;

class MyArrayList {
    private Object[] array;

    MyArrayList(int size){
        this.array = new Object[size];
    }

    public void fillNumbers(){
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(10);
        }
    }

    public void fillWords(){
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            char code = (char) (new Random().nextInt(94) + 33);
            array[i] = string.append(code);
        }
    }

    public Object[] add(Object value){
        int size = array.length; size++;
        Object[] secondArray = Arrays.copyOf(array, size);
        for (int i = array.length; i < size; i++) {
            secondArray[i] = value;
            }
       return array = Arrays.copyOf(secondArray, size);
    }

    public Object[] remove(int index){
        int size = array.length; size--;
        int indx = 0;
        Object[] secondArray = new Object[size];
        for (int i = 0; i < size; i++) {
            if( i != index){
                indx++;
                secondArray[i] = array[indx];
            } else {
                indx++;
                secondArray[i] = array[indx];
            }
        }
        return array = Arrays.copyOf(secondArray, size);
    }

    public Object[] clear(){
        Object[] secondArray = new Object[0];
        return array = Arrays.copyOf(secondArray, secondArray.length);
    }

    public int size(){
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
                count =  array[i];
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return  Arrays.toString(array);
    }

    public static void main(String[] args) {
         MyArrayList list = new MyArrayList(5);
         list.fillNumbers();
        list.add(1);
        list.add(1);

        System.out.println(list);
        System.out.println("-----------------");

        list.remove(0);
        System.out.println(list);
        System.out.println("-----------------");
        System.out.println(list.size());

        System.out.println("-----------------");
        System.out.println(list.get(1));

        System.out.println("-----------------");
        list.clear();
        System.out.println(list);


        System.out.println("-----------------");
        MyArrayList list1 = new MyArrayList(5);
        list1.fillWords();
        System.out.println(list1);

        System.out.println("-----------------");
        list1.add("Q");
        System.out.println(list1);

        System.out.println("-----------------");
        list1.remove(0);
        System.out.println(list1);

        System.out.println("-----------------");
        System.out.println(list1.get(4));
     }
}