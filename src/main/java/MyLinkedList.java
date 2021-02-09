import org.w3c.dom.Node;

import java.util.Arrays;
import java.util.LinkedList;

public class MyLinkedList<E> {

    private static class NodeMyNode<E> {
        E item;
        NodeMyNode<E> next;
        NodeMyNode<E> prev;

        NodeMyNode(NodeMyNode<E> prev, E element, NodeMyNode<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private int size = 0;
    private NodeMyNode<E> first;
    private NodeMyNode<E> last;

    public void add(E element) {
        NodeMyNode<E> lastTemp = last;
        NodeMyNode<E> newNode = new NodeMyNode<>(lastTemp, element, null);
        last = newNode;
        if (lastTemp == null) {
            first = newNode;
        } else {
            lastTemp.next = newNode;
        }
        size++;
    }

    public E remove(int index) {
        checkIndexElement(index);
        return unlink(findIndex(index));
    }

    E unlink (NodeMyNode<E> deleteElement) {
        final E element = deleteElement.item;
        final NodeMyNode<E> next = deleteElement.next;
        final NodeMyNode<E> prev = deleteElement.prev;

        if(prev == null) {
            first = next;
        }else{
            prev.next = next;
            deleteElement.prev = null;
        }

        if(next == null) {
            last = prev;
        }else{
            next.prev = prev;
            deleteElement.next = null;
        }

        deleteElement.item = null;
        size--;
        return element;
    }



    private boolean isCorrectIndex (int index) {
        return index >=0 && index < size;
    }

    public void clear() {
        last = null;
        first = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        checkIndexElement(index);
        return findIndex(index).item;
    }

    private void checkIndexElement(int index) {
        if(!isCorrectIndex(index)){
            throw new IndexOutOfBoundsException();
        }
    }

    NodeMyNode<E> findIndex(int index) {
        NodeMyNode<E> findingIndex = first;
        for (int i = 0; i <index ; i++) {
            findingIndex = findingIndex.next;
        }
        return findingIndex;
    }

    public E[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (MyLinkedList.NodeMyNode<E> x = first; x != null; x = x.next)
            result[i++] = x.item;
        return (E[]) result;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray());
    }

    public static void main(String[] args) {

        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.add("Java");
        myLinkedList.add("Hello");
        myLinkedList.add("C++");
        System.out.println(myLinkedList);
        System.out.println("-------------------------------------");
        System.out.println("[" + myLinkedList.get(1) + "]");
        System.out.println("-------------------------------------");
        System.out.println( "[" + myLinkedList.size() + "]" );
        System.out.println("-------------------------------------");
        System.out.println("[" + myLinkedList.remove(0) + "]");
        System.out.println("-------------------------------------");
        myLinkedList.clear();
        System.out.println(myLinkedList);
    }
}
