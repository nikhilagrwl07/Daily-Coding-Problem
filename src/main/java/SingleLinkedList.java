package main.java;

public class SingleLinkedList {
    public static Node buildSingleLinkedList() {
        Node fifty = new Node(50, null);
        Node hundred = new Node(100, fifty);
        Node zero = new Node(0, hundred);
        Node one = new Node(1, zero);
        Node eight = new Node(8, one);
        Node five = new Node(5, eight);
        Node ten = new Node(10, five);
        Node head = ten;
        return head;
    }


    static class Node {
        int value;
        Node next;

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
}
