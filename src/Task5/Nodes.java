package Task5;

class Nodes<K,V> {
    final K key;
    V value;
    Nodes<K,V> next;
    Nodes(K key,V value) {
        this.key = key;
        this.value = value;
        next = null;
    }

    public  K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}