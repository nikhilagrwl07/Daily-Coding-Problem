package main.java;

import java.util.ArrayList;
import java.util.List;

/*
This problem was asked by Microsoft.

Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list. If there is more than one possible reconstruction, return any of them. If there is no possible reconstruction, then return null.

For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox", you should return ['the', 'quick', 'brown', 'fox'].

Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond", return either ['bed', 'bath', 'and', 'beyond] or ['bedbath', 'and', 'beyond'].
 */
public class ReconstructionOfStringUsingDictionaryWords {
    public static void main(String[] args) {
//        String[] dictionary = {"bed", "bath", "bedbath", "and", "beyond"};
//        String word = "bedbathandbeyond";

        String[] dictionary = {"quick", "brown", "the", "fox"};
        String word = "thequickbrownfox";

        Trie trie = new Trie();
        trie.constructTrie(dictionary);

        List<String> result = trie.searchWord(word);

        System.out.println(result.toString());
    }
}


class Trie {

    TNode root;


    void constructTrie(String[] dictionary) {
        root = new TNode('\0');

        for (String word : dictionary) {
            insert(word);
        }
    }


    private void insert(String word) {
        TNode rt = root;

        char[] chars = word.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char currentChar = chars[i];

            int index = currentChar - 'a';

            TNode rtTmp = rt.getChildren()[index];

            if (rtTmp == null) {
                rtTmp = new TNode(currentChar);

                if (i == (chars.length - 1)) {
                    rtTmp.setCompleteWord(true);
                }

                rt.getChildren()[index] = rtTmp;

            }
            rt = rtTmp;

        }
    }

    public List<String> searchWord(String word) {

        TNode rt = root;
        List<String> result = new ArrayList<>();

        char[] chars = word.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {

            int currentIndex = chars[i] - 'a';
            rt = rt.getChildren()[currentIndex];

            if (rt == null) {
                return null;
            } else if (chars[i] == rt.getC()) {
                sb.append(rt.getC());

                if (rt.isCompleteWord()) {
                    result.add(sb.toString());
                    sb = new StringBuilder();
                    rt = root;
                }
            }
        }

        return result;
    }
}

class TNode {

    private char c;
    private TNode[] children;
    private boolean isCompleteWord = false;

    public TNode(char c) {
        this.c = c;
        this.children = new TNode[26];
    }

    public char getC() {
        return c;
    }

    public void setC(char c) {
        this.c = c;
    }

    public TNode[] getChildren() {
        return children;
    }

    public void setChildren(TNode[] children) {
        this.children = children;
    }

    public boolean isCompleteWord() {
        return isCompleteWord;
    }

    public void setCompleteWord(boolean completeWord) {
        isCompleteWord = completeWord;
    }
}