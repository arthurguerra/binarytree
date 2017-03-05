import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Test binary tree creation from an array.
 */
public class TestTreeCreationFromArray {
    private BinaryTreeService bts;

    @Before
    public void setUp() {
        bts = new BinaryTreeServiceImpl();
    }

    @Test
    public void testCreateTreeFromArray() {
        Integer[] preOrderTreeArray = {1, 2, 3, 4, 5};

        TreeNode root = bts.createTreeFromArray(preOrderTreeArray);

        Assert.assertEquals(1, root.getValue());
        Assert.assertEquals(2, root.getLeft().getValue());
        Assert.assertEquals(3, root.getRight().getValue());
        Assert.assertEquals(4, root.getLeft().getLeft().getValue());
        Assert.assertEquals(5, root.getLeft().getRight().getValue());
    }

    @Test
    public void testCreateTreeFromArrayWithNulls() {
        Integer[] preOrderTreeArray = {1, 2, null, 3, null, 4, null, 5, null};

        TreeNode root = bts.createTreeFromArray(preOrderTreeArray);

        Assert.assertEquals(1, root.getValue());
        Assert.assertEquals(2, root.getLeft().getValue());
        Assert.assertEquals(3, root.getLeft().getLeft().getValue());
        Assert.assertEquals(4, root.getLeft().getLeft().getLeft().getValue());
        Assert.assertEquals(5, root.getLeft().getLeft().getLeft().getLeft().getValue());
    }

    @Test
    public void testHeight() {
        Integer[] preOrderTreeArray = {1, 2, 3, 4, 5};

        TreeNode root = bts.createTreeFromArray(preOrderTreeArray);

        Assert.assertEquals(2, bts.findHeight(root));
        Assert.assertEquals(1, bts.findHeight(root.getLeft()));
        Assert.assertEquals(0, bts.findHeight(root.getRight()));
    }

    @Test
    public void testIsBalancedTree() {
        Integer[] preOrderTreeArray = {1, 2, 3, 4, 5};

        TreeNode root = bts.createTreeFromArray(preOrderTreeArray);

        Assert.assertTrue(bts.isBalanced(root));
    }

    @Test
    public void testNotBalancedTree() {
        Integer[] preOrderTreeArray = {1, 2, null, 3, null, 4, null, 5};

        TreeNode root = bts.createTreeFromArray(preOrderTreeArray);

        Assert.assertFalse(bts.isBalanced(root));
    }

}
