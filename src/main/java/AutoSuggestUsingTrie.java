package main.java;

public class AutoSuggestUsingTrie {
    private static final int numberOfChildren = 26;

    public static void main(String[] args) {
        TrieNode root = new TrieNode('0');
        String[] words = {"an", "ant", "all", "allot", "alloy", "aloe", "are", "ate", "be"};

        for (int i = 0; i < words.length; i++) {
            insert(root, words[i]);
        }
//        printTrie(root, 6);

//        String searchElement = "alloy";
//        System.out.println("Element " + searchElement + " found - ? " + search(root, searchElement));

        String prefixStringToAutoSuggest = "allo";

        autoSuggest(root, prefixStringToAutoSuggest);
    }

    private static TrieNode insert(TrieNode root, String word) {

        char[] wordInCharArray = word.toCharArray();
        TrieNode crawler = root;

        int currentIndex = 0;

        while (currentIndex <= word.length() - 1) {
            int index = wordInCharArray[currentIndex] - 97;
            TrieNode child = crawler.getChildren()[index];
            if (child == null) {
                crawler.getChildren()[index] = new TrieNode(wordInCharArray[currentIndex]);
            }

            if (currentIndex == word.length() - 1) {
                crawler.getChildren()[index].setFullWord(true);
            }
            currentIndex++;
            crawler = crawler.getChildren()[index];
        }
        return root;
    }


    private static boolean search(TrieNode root, String element) {

        if (root == null ||
                element == null || element.isEmpty()) {
            return false;
        }

        char[] chars = element.toCharArray();

        for (char ch : chars) {
            int index = ch - 97;
            TrieNode[] children = root.getChildren();

            if (children[index] == null)
                return false;
            else {
                root = children[index];
            }
        }
        return root.isFullWord();
    }

    private static void autoSuggest(TrieNode root, String prefixToSearch) {
        if (root == null ||
                prefixToSearch == null || prefixToSearch.isEmpty()) {
            return;
        }

        char[] chars = prefixToSearch.toCharArray();

        char[] result = new char[10];
        int resultIndex = 0;


        for (char ch : chars) {

            // Just for copying the prefix element to be searched
            result[resultIndex++] = ch;

            int index = ch - 97;
            TrieNode[] children = root.getChildren();

            if (children[index] == null) {
                System.out.println("Nothing to suggest!!");
                return;
            } else {
                root = children[index];
            }
        }
        autoSuggestUtil(root, result, resultIndex);
    }


    private static void autoSuggestUtil(TrieNode root, char[] result, int resultIndex) {

        for (TrieNode node : root.getChildren()) {
            if (node != null) {
                result[resultIndex] = node.getValue();
                autoSuggestUtil(node, result, resultIndex + 1);
            }
        }

        if (root.isFullWord()) {
            for (int i = 0; i < resultIndex; i++) {
                System.out.print(result[i]);
            }
            System.out.println();
        }
    }

    private static void printTrie(TrieNode root, int height) {

        for (int i = 0; i < numberOfChildren; i++) {
            printTrieUtil(root.getChildren()[i], 0, new char[height]);
        }

    }

    // recursively printing the trie
    private static void printTrieUtil(TrieNode root, int currentIndex, char[] c) {

        if (root == null || root.getValue() == '0')
            return;

        c[currentIndex] = root.getValue();

        if (root.isFullWord()) {
            for (int j = 0; j <= currentIndex; j++) {
                System.out.print(c[j]);
            }
            System.out.println();
        }

        for (int i = 0; i < numberOfChildren; i++) {
            printTrieUtil(root.getChildren()[i], currentIndex + 1, c);
        }
    }
}


class TrieNode {
    private static final int numberOfChildren = 26;
    private char value;
    private TrieNode[] children;
    private boolean isFullWord;

    public TrieNode(char value) {
        this.value = value;
        this.children = new TrieNode[numberOfChildren];
        this.isFullWord = false;
    }

    public TrieNode(char value, boolean isFullWord) {
        this.value = value;
        this.children = new TrieNode[numberOfChildren];
        this.isFullWord = isFullWord;
    }

    public char getValue() {
        return value;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public boolean isFullWord() {
        return isFullWord;
    }

    public void setFullWord(boolean fullWord) {
        isFullWord = fullWord;
    }
}
