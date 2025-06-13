package org.unplugged.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class LinkedList {

    public static void main(String[] args) {
//        Node node1 = new Node(2, new Node(4, new Node(3)));
//        Node node2 = new Node(5, new Node(6, new Node(4)));
        Node head = new Node(1, new Node(2, new Node(3, new Node(4,
                new Node(5, new Node(6, new Node(7)))))));
        head = removeMiddle(head);
        Node node = new Node(1, new Node(2, new Node(3, new Node(4))));
        Node lastOdd = oddEvenList(node);
        System.out.println(node);
        Node newNode = new Node(4, new Node(10, new Node(2,
                new Node(3, new Node(12, new Node(4))))));
        System.out.println(maxTwinSum(newNode, new ArrayList<Integer>(), 0));
    }

    //TODO - This is yet to be solved
    public static Node addTwoNumbers(Node node1, Node node2, int val) {
        int nodeVal = node1.getVal() + node2.getVal() + val;
        if (nodeVal >= 10) {
            Node node = new Node();
            if (nodeVal == 10) {
                val = 1;
            } else {
                val = nodeVal % 10;
            }
            return addTwoNumbers(node1.getNext() != null ? node1.getNext() : new Node(),
                    node2.getNext() != null ? node2.getNext() : new Node(),
                    val);
        } else {
            Node node = new Node(nodeVal);
            return addTwoNumbers(node1.getNext() != null ? node1.getNext() : new Node(),
                    node2.getNext() != null ? node2.getNext() : new Node(),
                    0);
        }
    }

    /**
     * Function that removes the middle node and retunrs the head
     * @param node - is the head of the linked list
     * @return
     */
    public static Node removeMiddle(Node node) {
        if (node == null || node.getNext() == null) {
            return null;
        }
        remove(null, node, node.getNext());
        return node;
    }

    /**
     * Function that recursively traverses through the list by jumping one step and two steps simultaneously
     * and remove the middle node the second pointer reaches the end of the list(or last but one node in the list)
     *
     * If the size of the list is n then we remove the n/2th node
     * For n = 1, 2, 3, 4, and 5 the middle nodes are 0, 1, 1, 2, and 2
     *
     * @param prev - node previous to the oneStepNode
     * @param oneStepNode - node reached by jumping one node at a time
     * @param twoStepNode - node reached by jumping 2 nodes at a time
     */
    public static void remove(Node prev, Node oneStepNode, Node twoStepNode) {
        if (twoStepNode == null) {
            prev.setNext(oneStepNode.getNext());
            oneStepNode.setNext(null);
            return;
        }
        Node current = oneStepNode.getNext();
        prev = oneStepNode;
        Node next = twoStepNode.getNext();
        if (next != null && next.getNext() != null) {
            remove(prev, current, next.getNext());
        } else {
            remove(prev, current, null);
        }
    }

    public static Node oddEvenList(Node node) {
        Node even = node.getNext();
        if (node.getNext() != null) {
            Node lastOddNode = arrangeOddAndEven(node, even, even.getNext(), null);
            lastOddNode.setNext(even);
        }
        return node;
    }

    /**
     * Function that recursively sets the next nodes separately for even and odd nodes in the list
     *
     * @param oddNode - initially the head, but would be the odd node in the list in the subsequent method calls
     * @param evenNode - is the even node in the list
     * @param oddNodeNext - is the next node of the odd node
     * @param evenNodeNext - is the next node of the even node
     * @return - the last odd node in the list
     */
    public static Node arrangeOddAndEven(Node oddNode, Node evenNode, Node oddNodeNext, Node evenNodeNext) {
        if(oddNodeNext == null && evenNodeNext == null) {
            oddNode.setNext(null);
            evenNode.setNext(null);
            return oddNode;
        }
        if (oddNodeNext != null) {
            oddNode.setNext(oddNodeNext);
            return arrangeOddAndEven(oddNodeNext, evenNode, null, oddNodeNext.getNext());
        } else {
            evenNode.setNext(evenNodeNext);
            return arrangeOddAndEven(oddNode, evenNodeNext, evenNodeNext.getNext(), null);
        }
    }

    /**
     * Calculates the max twin sum in a linked list
     *
     * @param node - initially the head node and next node in the list for every subsequent call
     * @param nodeValues - the list that gets populated by the values of the node
     * @param index - 0 indexed
     * @return max twin sum where twin of a node i is calculated by n - 1 - i, where n is the total size of
     * the linked list
     */
    public static int maxTwinSum(Node node, List<Integer> nodeValues, int index) {
        if (node == null) {
            return 0;
        }
        nodeValues.add(node.getVal());
        int maxVal = maxTwinSum(node.getNext(), nodeValues, index + 1);
        if (index >= nodeValues.size()/ 2) {
            maxVal = Math.max(maxVal, node.getVal() + nodeValues.get(nodeValues.size() - 1 - index));
        }
        return maxVal;
    }

    static class Node {
        private int val;
        private Node next;

        public Node() {

        }
        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        public int getVal() {
            return this.val;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return this.next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
