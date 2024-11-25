import java.util.NoSuchElementException;

public class ArrayQueue<T> {

    /*
     * The initial capacity of the ArrayQueue.
     */
    public static final int INITIAL_CAPACITY = 10;

    private T[] backingArray;
    private int front;
    private int size;

    /**
     * This is the constructor that constructs a new ArrayQueue.
     *
     * Java does not allow for regular generic array creation,
     * so we cast an Object[] to a T[] to get the generic typing.
     */
    public ArrayQueue() {
        // DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the data to the back of the queue.
     *
     * If sufficient space is not available in the backing array, resize it to
     * double the current length. When resizing, copy elements to the
     * beginning of the new array and reset front to 0.
     *
     * Method should run in amortized O(1) time.
     *
     * @param data the data to add to the back of the queue
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void enqueue(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data is null");
        }
        if (size == backingArray.length) {
            T[] newArray = (T[]) new Object[backingArray.length * 2];

            for (int i = 0; i < size; i++) {
                newArray[i] = backingArray[(front + i) % backingArray.length];
            }
            backingArray = newArray;
            front = 0;
        }

        int back = (front + size) % backingArray.length;
        backingArray[back] = data;
        size++;
    }

    /**
     * Removes and returns the data from the front of the queue.
     *
     * If the queue becomes empty as a result of this call, do not reset
     * front to 0.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the queue
     * @throws java.util.NoSuchElementException if the queue is empty
     */
    public T dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }

        T removedData = backingArray[front];
        backingArray[front] = null;
        front = (front + 1) % backingArray.length;
        size--;
        return removedData;
    }

    /**
     * Returns the backing array of the queue.
     *
     * @return the backing array of the queue
     */
    public T[] getBackingArray() {
        return backingArray;
    }

    /**
     * Returns the size of the queue.
     *
     * @return the size of the queue
     */
    public int size() {
        return size;
    }
}
