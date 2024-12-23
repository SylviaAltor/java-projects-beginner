
import java.util.NoSuchElementException;

public class BST<T extends Comparable<? super T>> {

    private BSTNode<T> root;
    private int size;

    /**
     * Adds the data to the tree.
     *
     * Traverse the tree to find the appropriate location. If the data is
     * already in the tree, then nothing should be done (the duplicate
     * shouldn't get added, and size should not be incremented).
     *
     * Should be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to add to the tree.
     * @throws java.lang.IllegalArgumentException If data is null.
     */
    public void add(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if (data == null) {
            throw new IllegalArgumentException("Data is null");
        }

        root = addHelper(root, data);
    }

    private BSTNode<T> addHelper(BSTNode<T> current, T data) {
        if (current == null) {
            size++;  // Increase size of the tree
            return new BSTNode<>(data);  // Insert data as a new leaf node
        }

        if (data.compareTo(current.getData()) < 0) {
            current.setLeft(addHelper(current.getLeft(), data));
        } else if (data.compareTo(current.getData()) > 0) {
            current.setRight(addHelper(current.getRight(), data));
        }
        return current;
    }

    /**
     * Removes and returns the data from the tree matching the given parameter.
     *
     * There are 3 cases to consider:
     * 1: The node containing the data is a leaf (no children). In this case,
     * simply remove it.
     * 2: The node containing the data has one child. In this case, simply
     * replace it with its child.
     * 3: The node containing the data has 2 children. Use the SUCCESSOR to
     * replace the data. You should use recursion to find and remove the
     * successor (you will likely need an additional helper method to
     * handle this case efficiently).
     *
     * Must be O(log n) for best and average cases and O(n) for worst case.
     *
     * @param data The data to remove.
     * @return The data that was removed.
     * @throws java.lang.IllegalArgumentException If data is null.
     * @throws java.util.NoSuchElementException   If the data is not in the tree.
     */
    public T remove(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Data is null");
        }

        root = removeHelper(root, data);

        size--;

        return data;
    }

    private BSTNode<T> removeHelper(BSTNode<T> current, T data) {
        if (current == null) {
            throw new NoSuchElementException("Data is not in the tree");
        }

        if (data.compareTo(current.getData()) < 0) {
            current.setLeft(removeHelper(current.getLeft(), data));
        } else if (data.compareTo(current.getData()) > 0) {
            current.setRight(removeHelper(current.getRight(), data));
        } else {
            // node has no child
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }

            // only one child
            if (current.getLeft() == null) {
                return current.getRight();
            }

            if (current.getRight() == null) {
                return current.getLeft();
            }

            // have two children
            T successorData = findSuccessor(current.getRight());
            // Replace current node's data with successor's data
            current.setData(successorData);
            // Remove successor
            current.setRight(removeHelper(current.getRight(), successorData));
        }
        return current;
    }

    private T findSuccessor (BSTNode<T> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node.getData();
    }

    /**
     * Returns the root of the tree.
     *
     * @return The root of the tree
     */
    public BSTNode<T> getRoot() {
        return root;
    }

    /**
     * Returns the size of the tree.
     *
     * @return The size of the tree
     */
    public int size() {
        return size;
    }
}
