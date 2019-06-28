package main.java;

public class ReverseLevelOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = BinaryTree.buildSampleTree();
        printReverseLevelOrder(root); //9 10 20 8 4 5 6 7 2 3 1

    }


    private static void printReverseLevelOrder(TreeNode root) {
        if (root == null) return;

        int height = height(root);

        for (int i = height; i >= 1; i--)
            printNodeAtGivenLevel(root, i);

    }

    private static void printNodeAtGivenLevel(TreeNode root, int level) {
        if (root == null)
            return;

        if (level == 1) {
            System.out.print(root.getValue() + " ");
        } else {
            printNodeAtGivenLevel(root.getLeft(), level - 1);
            printNodeAtGivenLevel(root.getRight(), level - 1);
        }

    }

    private static int height(TreeNode root) {

        if (root == null)
            return 0;

        return 1 + Math.max(height(root.getLeft()), height(root.getRight()));

    }


}

