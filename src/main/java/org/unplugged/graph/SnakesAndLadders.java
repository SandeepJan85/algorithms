package org.unplugged.graph;

public class SnakesAndLadders {

    int[][] board = {{-1,-1,-1,-1,-1,-1},
                     {-1,-1,-1,-1,-1,-1},
                     {-1,-1,-1,-1,-1,-1},
                     {-1,35,-1,-1,13,-1},
                     {-1,-1,-1,-1,-1,-1},
                     {-1,15,-1,-1,-1,-1}};

    public static void main(String[] a) {
        System.out.println(getCellCoordinatesByCellNumber(7, 6, 6));
    }

    public void findLeastDiceRolls(int i, int j, Queue queue, int diceRoll, int numDiceRolls) {
        if (i % 2 != 0) {

        } else {

        }
    }

    public static Node getCellCoordinatesByCellNumber(int number, int rowLen, int colLen) {
        int row = rowLen - (int) Math.floor(number / colLen) - 1;
        int mod = number % colLen;
        if (row % 2 != 0) {
            return new Node(row, mod == 0 ? colLen - 1 : mod - 1);
        }
        return new Node(row, colLen - mod - 1);
    }

    static class Queue {
        private Node head;
        private Node tail;
        private int length;

        public void push(int i, int j) {
            Node node = new Node(i, j);
            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.setNext(node);
            }
            this.tail = node;
            this.length++;
        }

        public Node pop() {
            if (length != 0) {
                Node newHead = this.head.getNext();
                this.head.setNext(null);
                this.head = newHead;
                this.length--;
                return newHead;
            }
            return null;
        }
    }

    static class Node {
        private final int row;
        private final int column;
        private Node next;

        public Node(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return this.row;
        }

        public int getColumn() {
            return this.column;
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
                    "row=" + row +
                    ", column=" + column +
                    '}';
        }
    }
}

