package main.java;

import static main.java.SingleLinkedList.Node;

public class MergeSortOnSingleLinkedList {
    public static void main(String[] args) {

        Node head = SingleLinkedList.buildSingleLinkedList();

        System.out.println("Before sorting...");
        printLinkedList(head);

        head = mergeSortOnSingleLinkedList(head);

        System.out.println("After sorting...");
        printLinkedList(head);
    }

    private static Node mergeSortOnSingleLinkedList(Node head) {
        if (head == null || head.getNext() == null)
            return head;

        Node middleNode = findMiddleNode(head);
        Node nodeNextToMiddleNode = middleNode.getNext();

        middleNode.setNext(null);

        // head is pointing to start of first half
        // nodeNextToMiddleNode is pointing to start of second half
        Node firstHalf = mergeSortOnSingleLinkedList(head);
        Node secondHalf = mergeSortOnSingleLinkedList(nodeNextToMiddleNode);

        head = mergeTwoSortedLinkedList(firstHalf, secondHalf);
        return head;
    }

    private static Node mergeTwoSortedLinkedList(Node firstHalf, Node secondHalf) {

        if (firstHalf == null) return secondHalf;
        if (secondHalf == null) return firstHalf;

        Node head = null, realHead = null;

        while (firstHalf != null && secondHalf != null) {

            if (head == null) {
                if (firstHalf.getValue() < secondHalf.getValue()) {
                    head = firstHalf;
                    firstHalf = firstHalf.getNext();
                } else {
                    head = secondHalf;
                    secondHalf = secondHalf.getNext();
                }
                realHead = head;
            } else {
                if (firstHalf.getValue() < secondHalf.getValue()) {
                    head.next = firstHalf;
                    firstHalf = firstHalf.getNext();
                } else {
                    head.next = secondHalf;
                    secondHalf = secondHalf.getNext();
                }
                head = head.getNext();
            }
        }


        if (firstHalf == null) {
            head.next = secondHalf;
        } else {
            head.next = firstHalf;
        }

        return realHead;
    }

    private static Node findMiddleNode(Node head) {

        Node slow = head, fast = head;

        // 1, 2
        // 1, 2, 3
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    private static void printLinkedList(Node head) {

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " --> ");
            temp = temp.getNext();
        }
        System.out.println();
    }
}
