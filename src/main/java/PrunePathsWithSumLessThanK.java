package main.java;

public class PrunePathsWithSumLessThanK {
    public static void main(String[] args) {
        TreeNode root = BinaryTree.buildSampleTree();
        int sum = 19;

        System.out.println("Before pruning tree..");
        BinaryTree.levelOrderQueue(root);

        prunePathsWithSumLessThanK(root, sum);

        System.out.println("After pruning tree..");
        BinaryTree.levelOrderQueue(root);

    }

    private static TreeNode prunePathsWithSumLessThanK(TreeNode root, int sum) {

        if (root == null)
            return null;

        int remainingSum = sum - root.getValue();

        root.setLeft(prunePathsWithSumLessThanK(root.getLeft(), remainingSum));
        root.setRight(prunePathsWithSumLessThanK(root.getRight(), remainingSum));

        if (isLeaf(root) && remainingSum > 0) {
            return null;
        }

        return root;
    }

    private static boolean isLeaf(TreeNode root) {
        return root.getLeft() == null && root.getRight() == null;
    }
}
