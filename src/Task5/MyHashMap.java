package Task5;

class MyHashMap<K, V> {
    private int size = 5;
    int length = 0;
    int index = 0;
    Nodes<K, V>[] table;

    MyHashMap() {
        table = new Nodes[size];
    }

    @Override
    public int hashCode() {
        return this.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Nodes<K, V> secondTable = table[size];
        if (this == obj)
            return true;
        else if (obj == null || obj.getClass() != getClass())
            return false;
        MyHashMap<K, V> myHashMap = (MyHashMap<K, V>) obj;
        return secondTable.getKey() == myHashMap && secondTable.getValue() == myHashMap;
    }

    public void put(K key, V value) {
        index = key.hashCode() % size - 1;
        if (length <= size && index >= 0) {

            Nodes<K, V> firstTable = new Nodes<>(key, value);
            Nodes<K, V> secondTable = table[index];

            if (table[index] == null) {
                table[index] = firstTable; //finding an empty bucket
                length++;
            } else while (secondTable != null) {
                if (secondTable.getKey().equals(key)) {
                    secondTable.next = firstTable;  //replace object
                    table[index] = secondTable.next;
                    break;
                } else {
                    secondTable.next = firstTable; //keep a reference to the next object
                    break;
                }
            }
        } else {
            size *= 2;
            Nodes<K, V>[] newTable = new Nodes[size];
            for (int i = 0; i < size / 2; i++) {
                if (table[i] != null) {
                    newTable[i] = table[i];
                }
            }
            table = newTable;
            put(key, value);
        }
    }

    public V get(K key) {
        V value = null;
        index = key.hashCode() % size - 1;
        Nodes<K, V> secondTable = table[index];
        while (secondTable != null) {
            if (secondTable.getKey().equals(key)) {
                value = secondTable.getValue();
                secondTable = secondTable.next;
            }
        }
        return value;
    }

    public Nodes<K, V> getBacked(Nodes<K, V> removeTable) {
        return removeTable;
    }

    public  Object remove(K key){
        Nodes<K, V> removeTable = null;
        index = key.hashCode() % size - 1;
        Nodes<K, V> secondTable = table[index];
            if (secondTable.getKey().equals(key)) {
                removeTable = table[index];
                table[index] = null;
        }
        return removeTable.getKey() + "=" + removeTable.getValue();
    }
    public int size() {
        return size;
    }

    public Nodes<K, V>[] clear() {
        size = 0;
        length = 0;
        return table = null;
    }

    @Override
    public String toString() {
        StringBuilder write = new StringBuilder();
        if (table == null){
            write.append("{").append("}");
            return  write.toString();
        }
        for (int i = 0; i < size; i++) {
            Nodes<K, V> secondTable = table[i];
            if (secondTable != null) {
                write.append(secondTable.getKey()).append("=").append(secondTable.getValue()).append(", ");
            }
        }
        write.deleteCharAt(write.lastIndexOf(", "));
        String show = write.toString();
        return "{" + show.strip() + "}";
    }

    public static void main(String[] args) {
        MyHashMap<Integer, String> hashMap = new MyHashMap<>();
        hashMap.put(1, "Oleg");
        hashMap.put(1, "Magamed");
        hashMap.put(2, "Anton");
        hashMap.put(3, "Masha");
        hashMap.put(4, "Egor");
        System.out.println(hashMap);
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.size());
        System.out.println(hashMap.remove(1));
        System.out.println(hashMap);
        hashMap.clear();
        System.out.println(hashMap);
    }
}