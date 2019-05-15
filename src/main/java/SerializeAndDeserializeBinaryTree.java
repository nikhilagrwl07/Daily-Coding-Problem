package main.java;

import java.util.ArrayList;
import java.util.List;

public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {

        TreeNode root = BinaryTree.buildSampleTree();
        BinaryTree.levelOrderQueueIterative(root);

        List<Integer> serializedListOfTree = new ArrayList<>();
        serialize(root, serializedListOfTree);

        System.out.println("Serialized format..");
        System.out.println(serializedListOfTree);

        TreeNode rootOfDeserializeTree = deserialize(serializedListOfTree);
        BinaryTree.levelOrderQueueIterative(rootOfDeserializeTree);
    }

    private static void serialize(TreeNode root, List<Integer> list) {
        if (root == null) {
            list.add(-1);
            return;
        }

        list.add(root.getValue());
        serialize(root.getLeft(), list);
        serialize(root.getRight(), list);
    }

    private static int currentIndex = 0;
    private static TreeNode deserialize(List<Integer> list) {
        if (list.isEmpty() || currentIndex >= list.size() || list.get(currentIndex) == -1)
        {
            currentIndex++;
            return null;
        }

        TreeNode root = new TreeNode(list.get(currentIndex));

        currentIndex++;

        root.setLeft(deserialize(list));
        root.setRight(deserialize(list));

        return root;
    }
}
