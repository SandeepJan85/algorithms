package org.unplugged.stack;

public class Stack {
    private Node head;
    private int length;

    public void push(String val) {
        Node newHead = new Node(val);
        if (head != null) {
            newHead.setNext(head);
        }
        head = newHead;
        length++;
    }

    public Node pop() {
        if (head != null) {
            Node oldHead = head;
            head = head.getNext();
            length--;
            return oldHead;
        }
        return null;
    }

    public int getLength() {
        return this.length;
    }

    static class Node {
        private String val;
        private Node next;

        Node(String val) {
            this.val = val;
        }

        public String getVal() {
            return this.val;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getNext() {
            return this.next;
        }
    }

}
