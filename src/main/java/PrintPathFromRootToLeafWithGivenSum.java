package main.java;

public class PrintPathFromRootToLeafWithGivenSum {

    public static void main(String[] args) {
        TreeNode root = BinaryTree.buildSampleTree();

        printPathWithSumK(root, 28);
    }

    private static void printPathWithSumK(TreeNode root, int sum) {
        if (root == null)
            return;

        int[] path = new int[height(root)];
        printPathWithSumKUtil(root, path, 0, sum);

    }

    private static void printPathWithSumKUtil(TreeNode root, int[] path, int pathLength, int sum) {

        if (root == null || sum < 0)
            return;

        int newSum = sum - root.getValue();
        path[pathLength] = root.getValue();

        if (newSum == 0 && isLeaf(root)) {
            printPath(path, pathLength);
        }
        printPathWithSumKUtil(root.getLeft(), path, pathLength + 1, newSum);
        printPathWithSumKUtil(root.getRight(), path, pathLength + 1, newSum);

    }

    private static boolean isLeaf(TreeNode root) {
        return root.getLeft() == null && root.getRight() == null;
    }

    private static void printPath(int[] path, int pathLength) {
        for (int i = 0; i <= pathLength; i++)
            System.out.print(path[i] + " ");

        System.out.println();

    }

    private static int height(TreeNode root) {

        if (root == null)
            return 0;

        return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
    }
}
