package main.java;

import java.util.LinkedList;
import java.util.Queue;

public class BoundaryOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = buildSampleTree();
        levelOrderQueue(root);

        System.out.println("Boundary Order Traversal");
        boundaryOrderTraversal(root);


    }

    private static TreeNode buildSampleTree() {
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

    private static void boundaryOrderTraversal(TreeNode root) {

        if (root == null)
            return;

        //Printing root node
        System.out.print(root.getValue() + " ");

        leftView(root.getLeft());   // top down approach

        bottomView(root.getLeft());
        bottomView(root.getRight());

        rightView(root.getRight());    // bottom up approach
    }

    private static void rightView(TreeNode root) {
        if(root!=null){
            if(root.getRight() != null){
                rightView(root.getRight());
                System.out.print(root.getValue() + " ");
            }
            else if (root.getLeft() !=null){
                rightView(root.getLeft());
                System.out.print(root.getValue() + " ");
            }
        }
    }


    private static void leftView(TreeNode root) {
        if (root != null) {
            if (root.getLeft() != null) {
                System.out.print(root.getValue() + " "); // printing node before calling it's left node to follow top down approach
                leftView(root.getLeft());
            }
            else if(root.getRight()!=null){
                System.out.print(root.getValue() + " "); // printing node before calling it's right node to follow top down approach
                leftView(root.getRight());
            }
        }
    }

    private static void bottomView(TreeNode root) {
        if (root == null)
            return;

        bottomView(root.getLeft());

        if (root.getLeft() == null && root.getRight() == null)
            System.out.print(root.getValue() + " ");

        bottomView(root.getRight());
    }

    private static void levelOrderQueue(TreeNode root) {
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

    public TreeNode getRight() {
        return right;
    }

    public int getValue() {
        return value;
    }
}
