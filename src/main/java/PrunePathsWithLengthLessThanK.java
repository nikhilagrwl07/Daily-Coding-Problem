package main.java;

public class PrunePathsWithLengthLessThanK {
    public static void main(String[] args) {
        TreeNode root = BinaryTree.buildSampleTree();
        int length = 5;

        System.out.println("Before pruning tree..");
        BinaryTree.levelOrderQueue(root);

        prunePathsWithLengthLessThanK(root, length);

        System.out.println("After pruning tree..");
        BinaryTree.levelOrderQueue(root);

    }

    private static TreeNode prunePathsWithLengthLessThanK(TreeNode root, int length) {

        if (root == null)
            return null;

        int remainingLength = length - 1;

        root.setLeft(prunePathsWithLengthLessThanK(root.getLeft(), remainingLength));
        root.setRight(prunePathsWithLengthLessThanK(root.getRight(), remainingLength));

        if (isLeaf(root) && remainingLength > 0) {
            return null;
        }

        return root;
    }

    private static boolean isLeaf(TreeNode root) {
        return root.getLeft() == null && root.getRight() == null;
    }
}
