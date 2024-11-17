import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {

    private SinglyLinkedListNode<T> head;
    private SinglyLinkedListNode<T> tail;
    private int size;

    /**
     * Adds the element to the front of the list.
     * Method should run in O(1) time.
     *
     * @param data the data to add to the front of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }

        head = new SinglyLinkedListNode<T>(data, head);

        //remember to change tail as well
        if (tail == null) {
            tail = head;
        }

        size++;
    }

    /**
     * Adds the element to the back of the list.
     * Method should run in O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws java.lang.IllegalArgumentException if data is null
     */
    public void addToBack(T data) {

        SinglyLinkedListNode<T> node = new SinglyLinkedListNode<T> (data, null);
        SinglyLinkedListNode<T> current = head;

        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    /**
     * Removes and returns the first data of the list.
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        T removedData;
        if (head == null) {
            throw new NoSuchElementException("The list is empty");
        }
        removedData = head.getData();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        size--;
        return removedData;
    }

    /**
     * Removes and returns the last data of the list.
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        T removedData;
        if (head == null) {
            throw new NoSuchElementException("The list is empty");
        } else if (head.getNext() == null) {
            removedData = head.getData();
            head = null;
            tail = null;
        } else {
            SinglyLinkedListNode<T> current = head;
            while (current.getNext() != tail) { //the next of current is the tail
                current = current.getNext();
            }
            removedData = tail.getData();
            current.setNext(null);
            tail = current;
        }
        size--;
        return removedData;
    }

    /**
     * Returns the head node of the list.
     *
     * @return the node at the head of the list
     */
    public SinglyLinkedListNode<T> getHead() {
        return head;
    }

    /**
     * Returns the tail node of the list.
     *
     * @return the node at the tail of the list
     */
    public SinglyLinkedListNode<T> getTail() {
        return tail;
    }

    /**
     * Returns the size of the list.
     *
     * @return the size of the list
     */
    public int size() {
        return size;
    }
}
