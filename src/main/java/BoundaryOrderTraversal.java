package main.java;

import java.util.LinkedList;
import java.util.Queue;

public class BoundaryOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = BinaryTree.buildSampleTree();
        BinaryTree.levelOrderQueueIterative(root);

        System.out.println("Boundary Order Traversal");
        boundaryOrderTraversal(root);


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



}
