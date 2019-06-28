package main.java;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    static TreeNode buildSampleTree() {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode ten = new TreeNode(10);

        TreeNode tweenty = new TreeNode(20);
        TreeNode eight = new TreeNode(8);

        TreeNode nine = new TreeNode(9);

        root.setBranches(two, three);
        two.setBranches(four, five);

        five.setBranches(ten, null);

        three.setBranches(six, seven);
        six.setBranches(tweenty, null);
        seven.setBranches(eight, null);
        eight.setBranches(nine, null);

        return root;
    }


    static void levelOrderQueueIterative(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode tt = (TreeNode) q.remove();
            System.out.print(tt.value + "  ");

            if (tt.left != null)
                q.add(tt.left);

            if (tt.right != null)
                q.add(tt.right);

        }

    }

}


class TreeNode {
    int value;
    TreeNode left, right;

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public TreeNode(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }

    public void setBranches(TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}

