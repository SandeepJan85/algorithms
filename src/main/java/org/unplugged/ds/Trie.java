package org.unplugged.ds;

import java.util.Arrays;

/**
 * Trie (Prefix Tree) - A dictionary to rapidly store and search strings.
 *
 * This implementation supports sequence of lower case alphabetical characters and can be easily extended
 * to support other character types as well(upper case alphabets, numerics,  etc..)
 */
public class Trie {

    public static final int NUM_CHAR = 26;
    public static final int CHAR_RANGE = 97;
    private TrieNode root = new TrieNode();

    /**
     * Function to store a string into the prefix tree. It recursively checks if the node for a prefix already
     * exists and creates one if it doesn't.
     *
     * @param str is the string that needs to be inserted into the prefix tree
     * @param node - The node passed in during the recursive call. Initially it's the root node which is passed
     * @return - true if the word is stored successfully or a false if the word already exists
     */
    public boolean insert(String str, TrieNode node) {
        if (str == null || str.equals("")) {
            node.setWordCount(node.getWordCount() + 1);
            if (node.isWord()) {
                return false;
            } else {
                node.setWord(true);
                return true;
            }
        }
        TrieNode[] nodeArr = node.getCharArray();
        if (nodeArr[str.charAt(0) - CHAR_RANGE] == null) {
            nodeArr[str.charAt(0) - CHAR_RANGE] = new TrieNode();
        }
        return insert(str.substring(1), nodeArr[str.charAt(0) - CHAR_RANGE]);
    }

    /**
     * Function that recursively searches if the node denoted by each of the characters in the string exist
     * in the tree.
     *
     * @param str - the string to search for in the prefix tree
     * @param node - the node which is denoted by each character prefix of the string
     * @return - true if the word exists or returns a false
     */
    public boolean search(String str, TrieNode node) {
        if (str == null || str.equals("")) {
            return node.isWord();
        }
        TrieNode[] nodeArr = node.getCharArray();
        if (nodeArr[str.charAt(0) - CHAR_RANGE] == null) return false;
        return search(str.substring(1), nodeArr[str.charAt(0) - CHAR_RANGE]);
    }

    /**
     * Function that deletes a word from the prefix tree. Only the nodes that do not have any child nodes
     * are deleted.
     *
     * @param str
     * @param node
     * @return true is the word is deleted or returns false
     */
    public boolean delete(String str, TrieNode node) {
        if (str == null || str.equals("")) {
            return node.isWord();
        }
        TrieNode[] nodeArr = node.getCharArray();
        if (nodeArr[str.charAt(0) - CHAR_RANGE] == null) return false;
        boolean delete = delete(str.substring(1), nodeArr[str.charAt(0) - CHAR_RANGE]);
        if (delete) {
            if (!hasChildren(nodeArr[str.charAt(0) - CHAR_RANGE].getCharArray())) {
                nodeArr[str.charAt(0) - CHAR_RANGE] = null;
            } else {
                nodeArr[str.charAt(0) - CHAR_RANGE].setWord(false);
                nodeArr[str.charAt(0) - CHAR_RANGE].setWordCount(0);
            }
        }
        return delete;
    }

    public boolean hasChildren(TrieNode[] nodeArr) {
        for (TrieNode node : nodeArr) {
            if (node != null) return true;
        }
        return false;
    }

    public static void main(String[] a) {
        Trie trie = new Trie();
        trie.insert("sandeep", trie.root);
    }

    /**
     * A node that holds pointers to only lower case alphabetical characters
     */
    static class TrieNode {
        private final TrieNode[] charArray;
        private boolean isWord;
        private int wordCount;

        public TrieNode() {
            this.charArray = new TrieNode[NUM_CHAR];
        }

        public TrieNode[] getCharArray() {
            return charArray;
        }

        public boolean isWord() {
            return isWord;
        }

        public void setWord(boolean word) {
            isWord = word;
        }

        public int getWordCount() {
            return wordCount;
        }

        public void setWordCount(int wordCount) {
            this.wordCount = wordCount;
        }

        @Override
        public String toString() {
            return "TrieNode{" +
                    "charArray=" + Arrays.toString(charArray) +
                    ", isWord=" + isWord +
                    ", wordCount=" + wordCount +
                    '}';
        }
    }
}
