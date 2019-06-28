package main.java;

public class BinaryTreeIsSubtreeOfAnotherBinaryTree {
    public static void main(String[] args) {
        TreeNode root = BinaryTree.buildSampleTree();
        BinaryTree.levelOrderQueueIterative(root);

        TreeNode subtreeRootNode = buildSubtree();

        TreeNode findRootOfSubTreeInParentTree = findRootOfSubTreeInParentTree(root, subtreeRootNode);

        if (isSubTree(findRootOfSubTreeInParentTree, subtreeRootNode)) {
            System.out.println("is subtree!!");
        } else
            System.out.println("Not subtree!!");

    }

    private static boolean isSubTree(TreeNode parent, TreeNode child) {
        if (parent == null && child == null)
            return true;

        if (parent != null && child == null)
            return true;

        if (parent == null && child != null)
            return false;


        if (parent.getValue() != child.getValue())
            return false;

        return isSubTree(parent.getLeft(), child.getLeft())
                &&
                isSubTree(parent.getRight(), child.getRight());

    }

    private static TreeNode findRootOfSubTreeInParentTree(TreeNode parentRoot, TreeNode childRoot) {
        if (parentRoot == null || childRoot == null)
            return null;

        if (parentRoot != null && parentRoot.getValue() == childRoot.getValue()) {
            return parentRoot;
        } else {
            TreeNode leftSubtreeResult = findRootOfSubTreeInParentTree(parentRoot.getLeft(), childRoot);
            if (leftSubtreeResult == null)
                return findRootOfSubTreeInParentTree(parentRoot.getRight(), childRoot);
            else
                return leftSubtreeResult;
        }
    }


    //building another smaller subtree
    private static TreeNode buildSubtree() {
        TreeNode three = new TreeNode(3);

        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode tweenty = new TreeNode(20);
        TreeNode eight = new TreeNode(8);
//        TreeNode nine = new TreeNode(9);
        three.setBranches(six, seven);
        six.setBranches(tweenty, null);
        seven.setBranches(eight, null);
//        eight.setBranches(nine, null);
        return three;
    }

}
