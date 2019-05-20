package main.java;

//       Original tree
//           10
//        /      \
//        -2        6
//        /   \      /  \
//        8     -4    7    5
//
//          Sum Tree
//           20(4-2+12+6)
//        /      \
//        4(8-4)      12(7+5)
//        /   \      /  \
//        0      0    0    0

public class ConvertingBinaryTreeToSumTree {
    public static void main(String[] args) {

        TreeNode root = BinaryTree.buildSampleTree();
        BinaryTree.levelOrderQueueIterative(root);

        System.out.println("Before conversion - In order traversal!!");
        recursiveInOrder(root);

        convertToSumTree(root);
        System.out.println("After conversion - In order traversal!!");
        recursiveInOrder(root);
    }

    private static int convertToSumTree(TreeNode r) {
        if (r == null)
            return 0;

        int temp = r.getValue();
        int sum = 0;

        // Collecting unchanged/original values of left and right child into
        // sum from return value of recursion
        int originalLeftChildValue = convertToSumTree(r.getLeft());
        int originalRightChildValue = convertToSumTree(r.getRight());

        sum += originalLeftChildValue + originalRightChildValue;

        // Collecting changed values of left and right child into
        // sum after passing and modifying children in recursion
        if (r.getLeft() != null) {
            sum += r.getLeft().getValue();
        }
        if (r.getRight() != null) {
            sum += r.getRight().getValue();
        }

        r.setValue(sum);
        return temp;
    }

    private static void recursiveInOrder(TreeNode r) {
        if (r == null)
            return;

        recursiveInOrder(r.getLeft());
        System.out.print(r.getValue() + " ");
        recursiveInOrder(r.getRight());
    }


}
