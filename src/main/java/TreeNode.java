/**
 * Representation of a node in a binary tree.
 */

public class TreeNode {
    private TreeNode left;
    private TreeNode right;
    private int value;

    public TreeNode(int value) {
        this.value = value;
        this.right = null;
        this.left = null;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(getValue());

        if(getLeft() != null) sb.append("    L:" + getLeft().getValue());
        if(getRight() != null) sb.append("    R:" + getRight().getValue());

        return sb.toString();
    }
}
