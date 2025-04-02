package org.unplugged.ds;

import java.util.HashMap;
import java.util.Map;

/**
 * LRU Cache - This uses a doubly linked list under the hood where every new/recently accessed entry
 * would be placed at the head of the linked list and the least recently used ones would eventually be
 * moved towards the tail of the list. The tail of the list would be removed once the capacity of the
 * cache is reached
 */
public class LRU {
    private final int capacity;
    private int size;
    private Node head;
    private Node tail;
    private final Map<String, Node> keyToNodeMap;

    public LRU(int capacity) {
        this.capacity = capacity;
        this.keyToNodeMap = new HashMap<>();
    }

    /**
     * Function that writes an entry to the cache.
     * If the key doesn't exist then a new key/value entry is written the cache.
     * If the key exists then the value along the position of the key/value entry are updated.
     * If the capacity of the cache is reached then the least accessed element will be removed from the cache.
     * @param key is the key in the key-value entry
     * @param val is the value in the key-value entry
     */
    public void put(String key, int val) {
        Node node;
        if (keyToNodeMap.containsKey(key)) {
            node = keyToNodeMap.get(key);
            node.setVal(val);
        } else {
            if (this.size == this.capacity) {
                Node newTail = this.tail.getPrev();
                this.tail.setPrev(null);
                keyToNodeMap.remove(this.tail.getKey());
                newTail.setNext(null);
                this.tail = newTail;
                this.size--;
            }
            node = new Node(key, val);
            keyToNodeMap.put(key, node);
            this.size++;
        }
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        } else {
            if (this.head != node) {
                node.setNext(this.head);
                this.head.setPrev(node);
                this.head = node;
            }
        }
    }

    /**
     * Function that gets an entry from the cache.
     * If the key exists the key/value pair is returned and also the position of the entry in the cache
     * is updated
     *
     * @param key is used to fetch the key/value pair from the cache
     * @return the Node containing the key and value if exists or returns a Null
     */
    public Node get(String key) {
        if (keyToNodeMap.containsKey(key)) {
            Node node = keyToNodeMap.get(key);
            if (this.size > 1) {
                if (this.tail == node) {
                    Node prev = node.getPrev();
                    prev.setNext(null);
                    this.tail = prev;
                    return node;
                }
                if (this.head != node) {
                    Node prev = node.getPrev();
                    Node next = node.getNext();
                    prev.setNext(next);
                    next.setPrev(next);
                }
                node.setPrev(null);
                node.setNext(this.head);
                this.head.setPrev(node);
                this.head = node;
            }
            return node;
        }
        return null;
    }

    public int getSize() {
        return this.size;
    }

    public Node getHead() {
        return this.head;
    }

    public static void main(String[] a) {
        LRU cache = new LRU(5);
    }
}

class Node {
    private String key;
    private int val;
    private Node next;
    private Node prev;

    Node(String key, int val) {
        this.key = key;
        this.val = val;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return this.next;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getPrev() {
        return this.prev;
    }

    public String getKey() {
        return this.key;
    }

    public void setVal(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key='" + key + '\'' +
                ", val=" + val +
                '}';
    }
}
