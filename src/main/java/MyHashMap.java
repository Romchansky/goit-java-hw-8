import java.util.Arrays;
import java.util.Objects;

public class MyHashMap<K, V> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;
    private MyNode<K, V>[] buckets;
    private int size;


    MyHashMap() {
        buckets = new MyNode[DEFAULT_CAPACITY];
    }

    private int indexHash(K key) {
        if (Objects.isNull(key)) {
            return 0;
        }
        return Math.abs(key.hashCode()) % DEFAULT_CAPACITY;
    }


    public void put(K key, V value) {
        int indexHash = indexHash(key);

        if (size > buckets.length * LOAD_FACTOR) {
            resize();
        }

        MyNode<K, V> newMyNode = new MyNode<>(key, value, null);
        if (buckets[indexHash] == null) {
            buckets[indexHash] = newMyNode;
            size++;
        } else {
            MyNode<K, V> previousNode = null;
            MyNode<K, V> currentNode = buckets[indexHash];
            while (currentNode != null) {
                if (currentNode.getKey().equals(key)) {
                    currentNode.setValue(value);
                    break;
                }
                previousNode = currentNode;
                currentNode = currentNode.getNext();

            }
            if (previousNode != null) {
                previousNode.setNext(newMyNode);
            }
            size++;
        }
    }

    public V get(K key) {
        int indexHashGet = indexHash(key);

        MyNode<K, V> myNode = buckets[indexHashGet];
        while (myNode != null) {
            if (myNode.getKey().equals(key)) {
                return myNode.getValue();
            }
            myNode = myNode.getNext();
        }
        return null;
    }


    public void remove(K key) {
        int indexHashRemove = indexHash(key);

        MyNode<K, V> previousNode = null;
        MyNode<K, V> myNode = buckets[indexHashRemove];
        while (myNode != null) {
            if (myNode.getKey().equals(key)) {
                if (previousNode == null) {
                    buckets[indexHashRemove] = myNode.getNext();
                    return;
                } else {
                    previousNode.setNext(myNode.getNext());
                    return;
                }
            }
            previousNode = myNode;
            myNode = myNode.getNext();
        }
    }

    public void clear() {
        int count = 0;
        while (count < buckets.length) {
            buckets[count] = null;
            count++;
        }
        size = 0;
    }

    public int size() {
        return size;
    }


    private void resize() {
        MyNode<K, V>[] oldBucket = Arrays.copyOf(buckets, buckets.length * 2);
        buckets = oldBucket;
    }

    static class MyNode<K, V> {
        private K key;
        private V value;
        MyNode<K, V> next;

        MyNode(K key, V value, MyNode<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public MyNode<K, V> getNext() {
            return next;
        }

        public void setNext(MyNode<K, V> next) {
            this.next = next;
        }

        @Override
        public final boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyNode<?, ?> that = (MyNode<?, ?>) o;
            return Objects.equals(key, that.key);
        }

        @Override
        public final int hashCode() {
            return Objects.hashCode(key);
        }

    }

    public void display() {
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i] != null) {
                MyNode<K, V> currentNode = buckets[i];
                System.out.println("-----------------------------------------");
                System.out.println("Bucket is: " + i);
                while (currentNode != null) {
                    System.out.println("Key is: " + currentNode.getKey() + ", value is: " + currentNode.getValue());
                    currentNode = currentNode.getNext();
                }
            }
        }
    }

    public static void main(String[] args) {

        MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
        myHashMap.put("Java", 1995);
        myHashMap.put("HTML", 554);
        myHashMap.put("JS", 1993);
        myHashMap.put("Hello", 145);
        myHashMap.put("Git", 954);
        myHashMap.put("Swift", 93);
        myHashMap.put("Kotlin", 1);
        myHashMap.put("C#", 9);
        myHashMap.put("C++", 23);
        myHashMap.put("CSS", 44);
        myHashMap.put("Java SE", 44);
        myHashMap.put("Go", 44);
        myHashMap.put("SQL", 44);
        myHashMap.put("Python", 44);
        myHashMap.display();
        System.out.println("-----------------------------------------");
        System.out.println("Get value is: " + myHashMap.get("Java"));
        System.out.println("-----------------------------------------");
        System.out.println("Size is: " + myHashMap.size());
        System.out.println("-----------------------------------------");
        System.out.println("Capacity is: " + myHashMap.buckets.length);
        System.out.println("-----------------------------------------");
        myHashMap.remove("Java");
        myHashMap.display();
        System.out.println("-----------------------------------------");
        myHashMap.clear();
        myHashMap.display();

    }
}
