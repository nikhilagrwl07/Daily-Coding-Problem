package main.java;

import java.util.LinkedList;
import java.util.Queue;

public class CousinNotSiblingInBinaryTree {

    public static void main(String[] args) {
        TreeNode root = BinaryTree.buildSampleTree();

        int first = 4;
        int second = 5;

        System.out.println(isCousinNotSibling(root, first, second));
    }

    public static boolean isCousinNotSibling(TreeNode root, int a, int b) {

        int levelOfNodeA = getLevelOfNodeIterative(root, a);
        int levelOfNodeB = getLevelOfNodeIterative(root, b);

        if (levelOfNodeB != -1 && levelOfNodeA == levelOfNodeB) {
            return !isSibling(root, a, b);
        }
        return false;
    }

    private static boolean isSibling(TreeNode root, int a, int b) {
        if (root == null)
            return false;

        // Condition for sibling
        if ((root.getLeft() != null && root.getLeft().getValue() == a
                && root.getRight() != null && root.getRight().getValue() == b)
                ||
                (root.getLeft() != null && root.getLeft().getValue() == b
                        && root.getRight() != null && root.getRight().getValue() == a))
            return true;

        return isSibling(root.getLeft(), a, b) || isSibling(root.getRight(), a, b);

    }


    private static int getLevelOfNodeIterative(TreeNode root, int node) {

        if (root.getValue() == node) {
            return 1;
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();

        q.add(root);
        q.add(null);
        int level = 0;

        while (!q.isEmpty()) {
            TreeNode tn = q.remove();

            if (tn == null) {
                level++;
                q.add(null);
            } else {
                if (tn.getValue() == node) {
                    return level;
                }
                if (tn.getLeft() != null)
                    q.add(tn.getLeft());

                if (tn.getRight() != null)
                    q.add(tn.getRight());
            }
        }
        return -1;
    }
}
