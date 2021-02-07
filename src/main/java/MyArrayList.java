import java.util.Arrays;

public class MyArrayList<E> {

    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private E[] element;

    public MyArrayList() {
        this.element = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public void add(E value) {
        if (size >= element.length) {
            ensureNewSize();
        }
        element[size++] = value;
    }

    public void ensureNewSize() {
        int newCapacity = (size * 3) / 2 + 1;
        element = Arrays.copyOf(element, newCapacity);
    }

    public void remove(int index) {
        for (int i = index; i < size; i++) {
            element[i] = element[i + 1];
        }
        element[size--] = null;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            element[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        return element[index];
    }


    @Override
    public String toString() {
        return Arrays.toString(element);
    }

    public static void main(String[] args) {

        MyArrayList<String> myArrayList = new MyArrayList<>();
        // add values in Array
        myArrayList.add("Hello");
        myArrayList.add("Java");
        myArrayList.add("World");
        System.out.println(myArrayList);

        // get size Array
        System.out.println("-----------------------------------------");
        System.out.println(myArrayList.size());

        // get index in Array
        System.out.println("-----------------------------------------");
        System.out.println(myArrayList.get(2));

        // remove index in Array
        System.out.println("-----------------------------------------");
        myArrayList.remove(0);
        System.out.println(myArrayList);

        // clear Array
        System.out.println("-----------------------------------------");
        myArrayList.clear();
        System.out.println(myArrayList);

        // new size in Array
        System.out.println("-----------------------------------------");
        myArrayList.add("A");
        myArrayList.add("B");
        myArrayList.add("C");
        myArrayList.add("D");
        myArrayList.add("E");
        myArrayList.add("F");
        myArrayList.add("G");
        myArrayList.add("H");
        myArrayList.add("I");
        myArrayList.add("J");
        myArrayList.add("X");
        System.out.println(myArrayList);

    }
}
