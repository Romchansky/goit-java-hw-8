import java.util.*;

public class MyQueue<E> {
    private static final int DEFAULT_QUEUE_CAPACITY = 11;
    private int sizeQueue = 0;
    private E[] elementQueue;

    MyQueue() {
        this.elementQueue = (E[]) new Object[DEFAULT_QUEUE_CAPACITY];
        this.sizeQueue = sizeQueue;
    }

    public void add(E value) {
        if (value == null) {
            throw new NullPointerException();
        }
        if (sizeQueue >= elementQueue.length) {
            growQueue();
        }
        elementQueue[sizeQueue++] = value;
    }

    private void growQueue() {
        int newCapacity = elementQueue.length + 1;
        elementQueue = Arrays.copyOf(elementQueue, newCapacity);
    }

    public E remove(int index) {
        for (int i = index; i < sizeQueue; i++) {
            elementQueue[i] = elementQueue[i + 1];
        }
        elementQueue[sizeQueue--] = null;
        return null;
    }

    public void clear() {
        sizeQueue = 0;
        elementQueue = (E[]) new Object[0];
    }

    public int size() {
        return elementQueue.length;
    }

    public E peek() {
        return (E) elementQueue[0];
    }

    public E poll() {
        return remove(0);
    }

    @Override
    public String toString() {
        return Arrays.toString(elementQueue);
    }

    public static void main(String[] args) {

        MyQueue<String> myQueue = new MyQueue<>();
        myQueue.add("Hello");
        myQueue.add("Java");
        myQueue.add("born");

        System.out.println(myQueue);
        System.out.println("-----------------------------------------");
        myQueue.remove(0);
        System.out.println(myQueue);
        System.out.println("-----------------------------------------");
        System.out.println("[" + myQueue.size() + "]");
        System.out.println("-----------------------------------------");
        System.out.println("[" + myQueue.peek() + "]");
        System.out.println("-----------------------------------------");
        System.out.println("[" + myQueue.poll() + "]");
        System.out.println("-----------------------------------------");
        myQueue.clear();
        System.out.println(myQueue);
    }
}
