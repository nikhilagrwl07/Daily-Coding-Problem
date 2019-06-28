package main.java;

public class IntersectionNodeOfTwoSinglyLinkedList {

    public static void main(String[] args) {

        Node rootOfA = new Node(3, new Node(7, new Node(8, new Node(10, null))));
//        Node rootOfB = new Node(3, new Node(7, new Node(8, new Node(10, null))));
        Node rootOfB = new Node(99, new Node(100, new Node(45, new Node(1, new Node(8, new Node(10, null))))));

        int ALength = length(rootOfA);
        int BLength = length(rootOfB);

        if (ALength > BLength) {
            int diff = ALength - BLength;
            rootOfA = traverseNLength(rootOfA, diff);
        } else if (ALength < BLength) {
            int diff = BLength - ALength;
            rootOfB = traverseNLength(rootOfB, diff);
        }

        Node intersectingNode = intersectingNode(rootOfA, rootOfB);

        if (intersectingNode != null) {
            System.out.println("Intersecting Node from End of both Singly Linked List - " + intersectingNode.getValue());
        } else {
            System.out.println("Intersecting Node not found");
        }
    }

    //        3 -> 7 -> 8 -> 10
//        99 -> 1 -> 8 -> 10
    static boolean isDone = false;

    private static Node intersectingNode(Node rootOfA, Node rootOfB) {

        if (rootOfA == null || rootOfB == null) {
            return null;
        }

        Node intersectingNode = intersectingNode(rootOfA.getNext(), rootOfB.getNext());

        if (!isDone && rootOfA.getValue() != rootOfB.getValue()) {
            isDone = !isDone;
            return rootOfA.getNext();
        }
        return intersectingNode;
    }

    private static int length(Node root) {
        if (root == null)
            return 0;

        return 1 + length(root.getNext());
    }

    private static Node traverseNLength(Node r, int diff) {

        while (diff > 0) {
            r = r.getNext();
            diff--;
        }
        return r;
    }

}

class Node {
    private int value;
    private Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}