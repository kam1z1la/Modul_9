package Task2;

class Nodes<E>{
  private final E next;
  E item;
  public E getNext() {return next;}
  public E getItem() {return item;}
  Nodes(E item){
   this.item = item;
   next = null;
  }
 }
