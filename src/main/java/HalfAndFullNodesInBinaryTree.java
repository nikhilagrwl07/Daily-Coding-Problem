package main.java;

public class HalfAndFullNodesInBinaryTree {
    public static void main(String[] args) {
        TreeNode root = BinaryTree.buildSampleTree();
        System.out.println(numberOfHalfNodes(root));
        System.out.println(numberOfFullNodes(root));
    }

    private static int numberOfHalfNodes(TreeNode root) {
        if (root == null)
            return 0;

        int count = 0;

        if ((root.getLeft() == null && root.getRight() != null)
                || (root.getLeft() != null && root.getRight() == null)) {
            count++;
        }
        return count + numberOfHalfNodes(root.getLeft()) + numberOfHalfNodes(root.getRight());
    }

    private static int numberOfFullNodes(TreeNode root) {
        if (root == null)
            return 0;

        int count = 0;

        if (root.getLeft() != null && root.getRight() != null) {
            count++;
        }
        return count + numberOfFullNodes(root.getLeft()) + numberOfFullNodes(root.getRight());
    }
}
