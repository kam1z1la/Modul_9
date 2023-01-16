package Task2;

class MyLinkedList<T>  {
      Nodes head;
      Nodes last;
     int counter = 0;
     MyLinkedList(){
          head = null;
          last = null;
     }
     public void add(T value){
     Nodes node = new Nodes(value);
     Nodes secondNode = head;
     if(head==null){
          head = (Nodes) node.getNext();
       } else while(secondNode.getNext() != null){
         last = (Nodes) secondNode.getNext();
       }
       last = node;
       counter++;
     }

     public static void main(String[] args) {
//     LinkedList<Integer> list = new LinkedList<>();
          MyLinkedList<Integer> list = new MyLinkedList<>();
         list.add(1);
     }
}