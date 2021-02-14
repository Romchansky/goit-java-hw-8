

public class MyStack<E> extends MyLinkedList<E> {

    public MyStack() {
    }

    public E peek() {
        return first.item;
    }

    public E pop() {
        E retDelElement = first.item;
        remove(0);
        return retDelElement;
    }

    public E push(E element) {
        add(element);
        return element;
    }


    public static void main(String[] args) {

        MyStack<String> stringMyStack = new MyStack<>();
        stringMyStack.push("Hello");
        stringMyStack.push("World");
        stringMyStack.push("Java");
        stringMyStack.push("Born in 1995");
        System.out.println(stringMyStack);
        System.out.println("-------------------------------------");
        System.out.println(stringMyStack.peek());
        System.out.println("-------------------------------------");
        System.out.println(stringMyStack.pop());
        System.out.println("-------------------------------------");
        System.out.println(stringMyStack);
    }
}
