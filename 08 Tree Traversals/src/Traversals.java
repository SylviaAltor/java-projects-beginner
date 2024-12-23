import java.util.List;
import java.util.ArrayList;

/**
 * The implementation of the pre-order, in-order, and post-order
 * traversals of a tree.
 */
public class Traversals<T extends Comparable<? super T>> {

    /**
     * Given the root of a binary search tree, generate a
     * pre-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the pre-order traversal of the tree.
     */
    public List<T> preorder(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }

    private void preorderHelper(TreeNode<T> node, List<T> result) {
        if (node != null) {
            result.add(node.getData());          // Visit root
            preorderHelper(node.getLeft(), result);  // Traverse left subtree
            preorderHelper(node.getRight(), result); // Traverse right subtree
        }
    }

    /**
     * Given the root of a binary search tree, generate an
     * in-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the in-order traversal of the tree.
     */
    public List<T> inorder(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        inorderHelper(root, result);
        return result;
    }

    private void inorderHelper(TreeNode<T> node, List<T> result) {
        if (node != null) {
            inorderHelper(node.getLeft(), result);
            result.add(node.getData());
            inorderHelper(node.getRight(), result);
        }
    }
    /**
     * Given the root of a binary search tree, generate a
     * post-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the post-order traversal of the tree.
     */
    public List<T> postorder(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        postorderHelper(root, result);
        return result;
    }

    private void postorderHelper(TreeNode<T> node, List<T> result) {
        if (node != null) {
            postorderHelper(node.getLeft(), result);
            postorderHelper(node.getRight(), result);
            result.add(node.getData());
        }
    }
}
