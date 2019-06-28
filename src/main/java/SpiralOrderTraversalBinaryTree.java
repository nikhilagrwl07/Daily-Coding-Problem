package main.java;

public class SpiralOrderTraversalBinaryTree {
    public static void main(String[] args) {
        TreeNode root = BinaryTree.buildSampleTree();
        BinaryTree.levelOrderQueueIterative(root);
        System.out.println();
        spiralOrderTraversalRecursive(root);
    }


    private static void spiralOrderTraversalRecursive(TreeNode root) {
        if (root == null)
            return;

        int height = height(root);
        boolean isReverse = true;
        for (int h = 1; h <= height; h++) {
            printCurrentLevelRecursive(root, h, isReverse);
            isReverse = !isReverse;
        }
    }

    private static void printCurrentLevelRecursive(TreeNode root, int level, boolean isReverse) {
        if (root == null)
            return;
        if (level == 1) {
            System.out.print(root.getValue() + " ");
        } else {
            if (isReverse) // R --> L
            {
                printCurrentLevelRecursive(root.getRight(), level - 1, isReverse);
                printCurrentLevelRecursive(root.getLeft(), level - 1, isReverse);
            } else { // L --> R
                printCurrentLevelRecursive(root.getLeft(), level - 1, isReverse);
                printCurrentLevelRecursive(root.getRight(), level - 1, isReverse);
            }
        }

    }

    private static int height(TreeNode node) {
        if (node == null)
            return 0;

        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }
}
