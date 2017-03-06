import java.util.Stack;

/**
 * Implementation of the binary tree service interface.
 */
public class BinaryTreeServiceImpl implements BinaryTreeService {

    @Override
    public TreeNode createTreeFromArray(Integer... preOrderTreeArray) {
        if (preOrderTreeArray == null) return null;

        TreeNode root = new TreeNode(preOrderTreeArray[0]);
        Stack<TreeNode> treeStack = new Stack<>();
        treeStack.push(root);

        for(int i = 1; i < preOrderTreeArray.length - 1; i+=2) {
            TreeNode node = treeStack.pop();

            Integer lvalue = preOrderTreeArray[i];
            Integer rvalue = preOrderTreeArray[i+1];

            if(rvalue != null) {
                TreeNode rightNode = new TreeNode(rvalue);
                node.setRight(rightNode);
                treeStack.push(rightNode);
            }

            if(lvalue != null) {
                TreeNode leftNode = new TreeNode(lvalue);
                node.setLeft(leftNode);
                treeStack.push(leftNode);
            }
        }

        return root;
    }

    @Override
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        return findHeight2(root) != -1;
    }


    /*public boolean isBalanced(TreeNode root) {
        // easiest solution O(nlogn): time O(h): space -> n = # nodes and h = height of the tree
        if(root == null) return true;

        boolean balanced = true;

        Stack<TreeNode> treeStack = new Stack<>();
        treeStack.push(root);

        while(!treeStack.isEmpty() && balanced) {
            TreeNode node = treeStack.pop();

            int lh = findHeight(node.getLeft());
            int rh = findHeight(node.getRight());
            balanced = Math.abs(lh - rh) <= 1;

            if(node.getRight() != null) treeStack.push(node.getRight());
            if(node.getLeft() != null) treeStack.push(node.getLeft());
        }

        return balanced;
    }*/

    @Override
    public int findHeight(TreeNode root) {
        if(root == null) return -1;

        int lh = findHeight(root.getLeft());
        int rh = findHeight(root.getRight());

        return Math.max(lh, rh) + 1;
    }

    public int findHeight2(TreeNode root) {
        // O(n): time O(h): space -> n = # nodes and h = height of the tree
        if(root == null) return 0;

        int lh = findHeight(root.getLeft());

        if(lh == -1) return -1;

        int rh = findHeight(root.getRight());

        if (rh == -1 || Math.abs(lh - rh) > 1) return -1;

        return Math.max(lh, rh) + 1;
    }
}
