/**
 * Binary tree operations.
 */
public interface BinaryTreeService {

    /**
     * Creates a binary tree from an preOrderTreeArray of integers
     * @param preOrderTreeArray nodes of the tree in pre-order (current, left, right)
     * @return root node
     */
    TreeNode createTreeFromArray(Integer... preOrderTreeArray);

    /**
     * Checks whether or not a binary tree is balanced.
     * @param root root of the tree
     * @return True if the tree is balanced. False, otherwise.
     */
    boolean isBalanced(TreeNode root);

    /**
     * Finds the height of a binary tree.
     * @param root root node
     * @return the height of a tree.
     */
    int findHeight(TreeNode root);

}
