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

    public void print(){
        StringBuilder write = new StringBuilder();
        Nodes<T> node = head;
        if(node == null){
            write.append("Head null");
        } else while(node.next != null){
            node = node.next;
            write.append(node.item);
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.print();
    }
}