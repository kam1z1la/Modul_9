package Task2;

class MyLinkedList<T> {
     Nodes<T> head;
     Nodes<T> last;
     int counter = 0;
     MyLinkedList(){
          head = null;
          last = null;
     }
     public void add(T value){
     Nodes<T> node = new Nodes<>(value);
     Nodes<T> secondNode = head;
     if(head == null){
          head =  node;
       } else {
         while (secondNode.getNext() != null) {
             last = secondNode;
         }
         last = node;
         counter++;
       }
     }

     public static void main(String[] args) {
//     LinkedList<Integer> list = new LinkedList<>();
          MyLinkedList<Integer> list = new MyLinkedList<>();
         list.add(1);
     }
}