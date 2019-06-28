package main.java;


class Interval {
    int low;
    int high;

    public Interval(int low, int high) {
        this.low = low;
        this.high = high;
    }
}

class InternalNode {
    int max;
    InternalNode left;
    InternalNode right;
    Interval i;

    public InternalNode() {
    }


    public InternalNode(InternalNode left, InternalNode right, Interval i) {
        this.left = left;
        this.right = right;
        this.i = i;
    }

    public InternalNode(InternalNode left, InternalNode right, Interval i, int max) {
        this.left = left;
        this.right = right;
        this.i = i;
        this.max = max;
    }


    @Override
    public String toString() {
        return "InternalNode{" +
                "low=" + i.low +
                ", high=" + i.high +
                " , max=" + max +
                '}';
    }
}

public class IntervalTree {

    public static void main(String args[]) {
        IntervalTree it = new IntervalTree();
        InternalNode root = null;
        root = it.insert(root, 10, 15);
        System.out.println("root.max = " + root.max);
        root = it.insert(root, 11, 13);

        System.out.println("root.max = " + root.max);
        root = it.insert(root, 18, 21);
        System.out.println("root.max = " + root.max);

//        root = it.insert(root, 20, 30);
        root = it.insert(root, 21, 25);
        System.out.println("root.max = " + root.max);
//    System.out.println("root.low = " + root.right.right.right.right.max);

        root = it.insert(root, 0, 7);
        System.out.println("root.max = " + root.max);

        System.out.println(it.isOverlap(root, 7, 9));
//        System.out.println(it.isOverlap(root, 11, 18));
//        System.out.println(it.isOverlap(root, 21, 22));
//        System.out.println(it.isOverlap(root, 12, 18));
//        System.out.println(it.isOverlap(root, 24, 26));
        System.out.println("total count = " + it.isOverlapWithCount(root, 10, 25));
        //total count = 4
    }

    private InternalNode insert(InternalNode root, int low, int high) {

        if (root == null) {
            Interval i = new Interval(low, high);
            InternalNode node = new InternalNode(null, null, i, high);
            return node;
        }

        if (low < root.i.low) {
            root.left = insert(root.left, low, high);
        } else {
            root.right = insert(root.right, low, high);
        }

        root.max = Math.max(root.i.high, high);
        return root;
    }

    private InternalNode isOverlap(InternalNode root, int low, int high) {
        if (root == null) {
            return null;
        }

        if (root.i.low <= high && root.i.high >= low) {
            return root;
        }

        if (root.left != null && root.left.max >= low) {
            return isOverlap(root.left, low, high);
        } else {
            return isOverlap(root.right, low, high);
        }
    }

    private int isOverlapWithCount(InternalNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        if (root.i.high >= low && root.i.low <= high) {
            System.out.println(root.toString());
            return 1 + (isOverlapWithCount(root.left, low, high) +
                    isOverlapWithCount(root.right, low, high)
            );
        }

        if (root.left != null && root.left.max > low) {
            return isOverlapWithCount(root.left, low, high);
        } else {
            return isOverlapWithCount(root.right, low, high);
        }
    }

}