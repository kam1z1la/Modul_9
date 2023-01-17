package Task2;

class MyLinkedList<T> {
    Nodes<T> head;
    int counter = 0;
    MyLinkedList(){
        head = null;
    }
    public void add(T value){
        Nodes<T> node = new Nodes<>(value);
        Nodes<T> secondNode = head;
        if(head == null){
            head =  node;
        } else {
            while (secondNode.next != null) {
                secondNode = secondNode.next;
            }
            secondNode.next = node;
            counter++;
        }
    }

    @Override
    public String toString() {
            StringBuilder write = new StringBuilder();
            Nodes<T> node = head;
            if(node == null){
                write.append("Head null");
            } else while(node != null){
                write.append(node.item).append("\t");
                node = node.next;
            }
            return write.toString();
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        System.out.println(list);
    }
}