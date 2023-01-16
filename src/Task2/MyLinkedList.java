package Task2;

class MyLinkedList<T>  {
      Nodes<T> head;
     int counter = 0;
     MyLinkedList(){
          head = null;
     }
     public void add(T value){
     Nodes<T> node = new Nodes<>(value);
     Nodes<T> secondNode = head;
     if(head==null){
          head = (Nodes<T>) node.getNext();
       } else while(secondNode.getNext() != null){
         secondNode = (Nodes<T>) secondNode.getNext();
       }
         secondNode = node;
       counter++;
     }

     public static void main(String[] args) {
//     LinkedList<Integer> list = new LinkedList<>();
          MyLinkedList<Integer> list = new MyLinkedList<>();
         list.add(1);
     }
}