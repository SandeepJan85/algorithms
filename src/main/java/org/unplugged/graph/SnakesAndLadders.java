package org.unplugged.graph;

public class SnakesAndLadders {

    public static void main(String[] a) {
        System.out.println(getCellCoordinatesByCellNumber(9, 6, 6));
        int[][] board = {{-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}};
        SnakesAndLadders game = new SnakesAndLadders();
        game.findLeastDiceRolls(board.length - 1, board[0].length - 1, board);
    }

    public void findLeastDiceRolls(int i, int j, int[][] board) {
        Queue queue = new Queue();
        putItemsInQueue(i, j, board, queue, null);
        System.out.println(queue.length);
    }

    public void putItemsInQueue(int i, int j, int[][] board, Queue queue, Node startNode) {
        int count = 0;
        while (count < 6) {
            if (i % 2 != 0) {
                if (j + 1 < board[i].length) {
                    j = j + 1;
                } else {
                    i = i - 1;
                }
            } else {
                if (j - 1 >= 0) {
                    j = j - 1;
                } else {
                    i = i - 1;
                }
            }
            if (i < 0) break;
            Node node = queue.push(i, j, startNode.getStepCount());
            node.incrementStepCount();
            count++;
        }
    }

    public static Node getCellCoordinatesByCellNumber(int number, int rowlen, int collen) {
        int row = rowlen - (int) Math.ceil((double) number / collen);
        int col;
        int mod = number % collen;
        if (row % 2 != 0) {
            col = mod == 0 ? collen - 1 : mod - 1;
        } else {
            col = mod != 0 ? collen - mod : 0;
        }
        return new Node(row, col);
    }

    static class Queue {
        private Node head;
        private Node tail;
        private int length;

        public Node push(int i, int j, int count) {
            Node node = new Node(i, j, count);
            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.setNext(node);
            }
            this.tail = node;
            this.length++;
            return node;
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
        private int stepCount;

        public Node(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public Node(int row, int column, int stepCount) {
            this(row, column);
            this.stepCount = stepCount;
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

        public void incrementStepCount() {
            this.stepCount++;
        }

        public int getStepCount() {
            return this.stepCount;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "row=" + row +
                    ", column=" + column +
                    ", next=" + next +
                    '}';
        }
    }
}

