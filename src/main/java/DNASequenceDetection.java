/*
    Problem -
    Solution -
    Time Complexity -
    Space Complexity -
 */


package main.java;

public class DNASequenceDetection {
    public static void main(String[] args) {
        String input = "ACAAAAACCCCCAAAAACCCCCCAAAAAGGGTTTCATGGCX";
        String[] genes = {"CAT", "TCATGGC", "GTAC"};

        DNASequenceDetection dnaSequenceDetection = new DNASequenceDetection();
        dnaSequenceDetection.searchDNASequence(input, genes);
    }

    private void searchDNASequence(String input, String[] genes) {

        Trie trie = new Trie();
        trie.buildTrie(genes);


        for (int i = 0; i < input.length(); i++) {

            for (String gene : genes) {
                if (i + gene.length() <= input.length()) {
                    String sequence = input.substring(i, i + gene.length());
//                    System.out.println("Sequence = " + sequence);
                    if (trie.search(sequence)) {
                        System.out.println("Pattern = " + sequence + " is present.");
                    }
                }

            }

        }


    }


    class Trie {
        TrieNode root;

        public Trie() {
        }

        public void insert(String gene) {
            TrieNode tmpRoot = root;

            char[] input = gene.toCharArray();
            for (int i = 0; i < input.length; i++) {
                if (tmpRoot.getChildren()[input[i] - 'A'] == null) {
                    tmpRoot.getChildren()[input[i] - 'A'] = new TrieNode(input[i]);

                    tmpRoot = tmpRoot.getChildren()[input[i] - 'A'];

                } else {
                    tmpRoot = tmpRoot.getChildren()[input[i] - 'A'];
                }

                if (i == input.length - 1) {
                    tmpRoot.setCompleteWord(true);
                }
            }
        }

        public boolean search(String dnaSequence) {
            char[] input = dnaSequence.toCharArray();
            TrieNode tmpRoot = root;

            for (int i = 0; i < input.length; i++) {
                if (tmpRoot.getChildren()[input[i] - 'A'] == null) {
                    return false;
                }
                tmpRoot = tmpRoot.getChildren()[input[i] - 'A'];
                if (tmpRoot.isCompleteWord() && i == input.length - 1) {
                    return true;
                }
            }
            return false;
        }

        private void buildTrie(String[] genes) {

            root = new TrieNode('\0');

            for (String i : genes) {
                insert(i);
            }
        }
    }


    class TrieNode {
        char c;
        TrieNode[] children;
        boolean isCompleteWord;

        public TrieNode(char c) {
            this.c = c;
            children = new TrieNode[26];
        }

        public TrieNode(char c, TrieNode[] children) {
            this.c = c;
            this.children = children;
        }

        public char getC() {
            return c;
        }

        public void setC(char c) {
            this.c = c;
        }

        public TrieNode[] getChildren() {
            return children;
        }

        public void setChildren(TrieNode[] children) {
            this.children = children;
        }

        public boolean isCompleteWord() {
            return isCompleteWord;
        }

        public void setCompleteWord(boolean completeWord) {
            isCompleteWord = completeWord;
        }
    }
}
