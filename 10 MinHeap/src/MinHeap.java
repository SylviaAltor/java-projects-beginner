import java.util.NoSuchElementException;

public class MinHeap<T extends Comparable<? super T>> {

    public static final int INITIAL_CAPACITY = 13;

    private T[] backingArray;
    private int size;

    public MinHeap() {
        backingArray = (T[]) new Comparable[INITIAL_CAPACITY];
    }

    public void add(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }

        if (size + 1 >= backingArray.length) {
            T[] newArray = (T[]) new Comparable[backingArray.length * 2];
            for (int i = 1; i <= size; i++) {
                newArray[i] = backingArray[i];
            }
            backingArray = newArray;
        }

        backingArray[++size] = data;
        int currentIndex = size;

        while (currentIndex > 1) {
            int parentIndex = currentIndex / 2;
            if (backingArray[currentIndex].compareTo(backingArray[parentIndex]) < 0) {
                T temp = backingArray[currentIndex];
                backingArray[currentIndex] = backingArray[parentIndex];
                backingArray[parentIndex] = temp;
                currentIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    public T remove() {
        if (size == 0) {
            throw new NoSuchElementException("Heap is empty");
        }

        T minValue = backingArray[1];
        backingArray[1] = backingArray[size];
        backingArray[size--] = null;

        int currentIndex = 1;

        while (currentIndex * 2 <= size) {
            int leftChild = currentIndex * 2;
            int rightChild = leftChild + 1;
            int smallerChild = leftChild;

            if (rightChild <= size && backingArray[rightChild].compareTo(backingArray[leftChild]) < 0) {
                smallerChild = rightChild;
            }

            if (backingArray[currentIndex].compareTo(backingArray[smallerChild]) > 0) {
                T temp = backingArray[currentIndex];
                backingArray[currentIndex] = backingArray[smallerChild];
                backingArray[smallerChild] = temp;
                currentIndex = smallerChild;
            } else {
                break;
            }
        }

        return minValue;
    }

    public T[] getBackingArray() {
        return backingArray;
    }

    public int size() {
        return size;
    }
}
