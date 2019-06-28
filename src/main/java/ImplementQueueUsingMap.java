/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package main.java;

import java.util.HashMap;
import java.util.Map;

public class ImplementQueueUsingMap {

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);

        int removedElement = q.remove();
        System.out.println(removedElement);

        q.add(50);
        q.add(60);

        removedElement = q.remove();
        System.out.println(removedElement);

        removedElement = q.remove();
        System.out.println(removedElement);
        removedElement = q.remove();
        System.out.println(removedElement);
        removedElement = q.remove();
        System.out.println(removedElement);
        removedElement = q.remove();
        System.out.println(removedElement);
        removedElement = q.remove();
        System.out.println(removedElement);

    }
}


class Queue {

    private Map<Integer, Integer> map;
    private int upperIndex;
    private int lowerIndex;
    private int size;


    public Queue(int size) {
        this.map = new HashMap<>(size);
        lowerIndex = 0;
        upperIndex = -1;
        this.size = size;
    }


    private boolean isSafeForAddition() {
        int diff = upperIndex - lowerIndex + 1;
        if (diff >= size) {
            return false;
        }
        return true;
    }

    private boolean isSafeForDeletion() {
        int diff = upperIndex - lowerIndex + 1;
        if (diff > 0) {
            return true;
        }
        return false;
    }

    boolean add(int element) {
        if (isSafeForAddition()) {
            map.put(++upperIndex, element);
            return true;
        }
        throw new QueueIsFullException("Queue is Full");
    }

    int remove() {
        if (isSafeForDeletion()) {
            Integer removedElement = map.get(lowerIndex);

            map.remove(lowerIndex);
            lowerIndex++;
            return removedElement;
        }
        throw new QueueIsEmptyException("Queue is Empty");
    }

}

class QueueIsEmptyException extends RuntimeException {
    public QueueIsEmptyException(String message) {
        super(message);
    }
}

class QueueIsFullException extends RuntimeException {
    public QueueIsFullException(String message) {
        super(message);
    }
}