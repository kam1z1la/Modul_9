package Task3;

class Nodes<E> {
    Nodes<E> next;
    E item;

    Nodes(E item) {
        this.item = item;
        next = null;
    }
}