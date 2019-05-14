package main.java;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class XORLinkedList {

    private static Map<Integer, Node> addrToNodeMapping = new HashMap<>();
    private static Map<Node, Integer> nodeToaddrMapping = new HashMap<>();

    public static void main(String[] args) {

        Node head = add(null, 10);
        add(head, 20);

        add(head, 40);
        add(head, 30);
        traverseXORLinkedList(head);
    }

    private static Node add(Node head, int value) {

        Node temp = head;
        Node previous = null;

        Node newNode = new Node(value);
        nodeToaddrMapping.put(newNode, newNode.hashCode());
        addrToNodeMapping.put(newNode.hashCode(), newNode);

        // First element to insert
        if (head == null) {
            temp = newNode;
            return temp;
        }

        while (temp != null) {

            if (temp.getXorAddr() == null) {
                temp.setXorAddr(nodeToaddrMapping.get(newNode));
                newNode.setXorAddr(nodeToaddrMapping.get(temp));
                return newNode;
            } else {
                Node current = temp;

                if (nodeToaddrMapping.get(previous) != null) {
                    temp = addrToNodeMapping.getOrDefault(temp.getXorAddr() ^ nodeToaddrMapping.get(previous), null);
                } else {
                    temp = addrToNodeMapping.getOrDefault(temp.getXorAddr(), null);
                }

                previous = current;
            }
        }

        previous.setXorAddr(nodeToaddrMapping.get(newNode) ^ previous.getXorAddr());
        newNode.setXorAddr(nodeToaddrMapping.get(previous));
        return newNode;
    }

    private static void traverseXORLinkedList(Node head) {
        Node temp = head;
        Node previous = null;

        while (temp != null) {

            System.out.println(temp.getValue());

            if (temp.getXorAddr() == null) {
                return;
            } else {
                Node current = temp;

                if (nodeToaddrMapping.get(previous) != null) {
                    temp = addrToNodeMapping.getOrDefault(temp.getXorAddr() ^ nodeToaddrMapping.get(previous), null);
                } else {
                    temp = addrToNodeMapping.getOrDefault(temp.getXorAddr(), null);
                }
                previous = current;
            }
        }
    }

    static class Node {
        private int value;
        private Integer xorAddr;

        Node(int value) {
            this.value = value;
        }

        public Node(int value, int xorAddr) {
            this.value = value;
            this.xorAddr = xorAddr;
        }

        public int getValue() {
            return value;
        }

        public Integer getXorAddr() {
            return xorAddr;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public void setXorAddr(Integer xorAddr) {
            this.xorAddr = xorAddr;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, xorAddr);
        }
    }
}
