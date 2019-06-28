package main.java;

public class FindKthSmallestInSorted2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {26, 29, 37, 48},
                {32, 33, 39, 50},
        };
        int k = 4;

        int kthSmallestElement = findKthSmallestElement(matrix, k);

        System.out.println(kthSmallestElement);
    }

    private static int findKthSmallestElement(int[][] matrix, int kthSmallest) {

        MinHeap minHeap = new MinHeap(matrix[0]);
        minHeap.buildMinHeap();

        while (kthSmallest > 1) {
            minHeap.deleteAndInsertAtRoot(matrix);
            kthSmallest--;
        }

        return minHeap.getRoot();
    }
}

class MinHeap {

    private HeapNode[] nodes;

    public MinHeap(int[] initialElement) {
        this.nodes = new HeapNode[initialElement.length];

        for (int i = 0; i < initialElement.length; i++) {
            nodes[i] = new HeapNode(initialElement[i], 0, i);
        }
    }

    void buildMinHeap() {
        int start = (nodes.length - 1) / 2;

        for (int i = start; i >= 0; i--) {
            heapifyTopDown(i, nodes.length - 1);
        }
    }


    void deleteAndInsertAtRoot(int[][] matrix) {

        HeapNode root = nodes[0];

        int newValue;
        if (root.getRow() + 1 <= matrix[0].length - 1) {
            newValue = matrix[root.getRow() + 1][root.getColumn()];
        } else {
            newValue = matrix[root.getRow()][root.getColumn() + 1];
        }
        root.setValue(newValue);
        root.setRow(root.getRow() + 1);
        root.setColumn(root.getColumn());

        heapifyTopDown(0, nodes.length - 1);
    }

    private void heapifyTopDown(int index, int size) {

        if (index > size) {
            return;
        }
        int left = getLeft(index);
        int right = getRight(index);
        int smallest = index;

        if (left <= size && nodes[smallest].getValue() > nodes[left].getValue()) {
            smallest = left;
        }
        if (right <= size && nodes[smallest].getValue() > nodes[right].getValue()) {
            smallest = right;
        }

        if (smallest != index) {
            swap(smallest, index);
            heapifyTopDown(smallest, size);
        }

    }

    private void swap(int firstIndex, int secondIndex) {

        HeapNode temp = nodes[firstIndex];
        nodes[firstIndex] = nodes[secondIndex];
        nodes[secondIndex] = temp;
    }

    private int getLeft(int index) {
        return 2 * index + 1;
    }

    private int getRight(int index) {
        return 2 * index + 2;
    }

    public int getRoot() {
        return nodes[0].getValue();

    }
}

class HeapNode {
    private int value;
    private int row;
    private int column;

    public HeapNode(int value, int row, int column) {
        this.value = value;
        this.row = row;
        this.column = column;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
