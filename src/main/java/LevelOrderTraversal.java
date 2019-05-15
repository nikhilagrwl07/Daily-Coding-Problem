package main.java;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = BinaryTree.buildSampleTree();
//        BinaryTree.levelOrderQueueIterative(root);
//        System.out.println();
        levelOrderQueueRecursive(root);

    }

    private static void levelOrderQueueRecursive(TreeNode root) {

        if (root == null)
            return;

        int height = height(root);

        for (int h = 1; h <= height; h++) {
            printCurrentLevelRecursive(root, h);
        }
    }

    private static void printCurrentLevelRecursive(TreeNode root, int level) {
        if (root == null)
            return;
        if (level == 1) {
            System.out.print(root.getValue() + " ");
        } else {
            printCurrentLevelRecursive(root.getLeft(), level - 1);
            printCurrentLevelRecursive(root.getRight(), level - 1);
        }

    }

    private static int height(TreeNode node) {
        if (node == null)
            return 0;

        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

}
