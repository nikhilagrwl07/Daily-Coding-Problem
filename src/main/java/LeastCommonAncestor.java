package main.java;

public class LeastCommonAncestor {

    private static boolean isFirstPresent = false, isIsSecondPresent = false;

    public static void main(String[] args) {
        TreeNode root = BinaryTree.buildSampleTree();

        int first = 10;
        int second = 8;

        TreeNode lcaNode = LCA(root, first, second);

        if (isIsSecondPresent && isFirstPresent) {
            System.out.println("LCA is " + lcaNode.getValue());
        } else {
            System.out.println("LCA is not present");
        }
    }

    private static TreeNode LCA(TreeNode root, int first, int second) {
        if (root == null)
            return null;

        TreeNode leftTemp = null, rightTemp = null;

        if (root.getValue() == first) {
            isFirstPresent = true;
            leftTemp = root;
        }

        if (root.getValue() == second) {
            isIsSecondPresent = true;
            rightTemp = root;
        }

        //If first is present in left subtree + second in right subtree --> root is LCA
        //If second is present in left subtree + first in right subtree --> root is LCA
        TreeNode leftLCA = LCA(root.getLeft(), first, second);
        TreeNode rightLCA = LCA(root.getRight(), first, second);

        if (leftTemp != null)
            return leftTemp;

        if (rightTemp != null)
            return rightTemp;


        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        return leftLCA == null ? rightLCA : leftLCA;
    }
}
