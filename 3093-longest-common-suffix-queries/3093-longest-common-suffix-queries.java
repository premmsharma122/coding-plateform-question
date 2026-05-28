// class Solution {
//     public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

//         int[] res = new int[wordsQuery.length];

//         for (int q = 0; q < wordsQuery.length; q++) {

//             String w = wordsQuery[q];

//             int bestIndex = 0;
//             int longestSuffix = -1;

//             for (int i = 0; i < wordsContainer.length; i++) {

//                 String s = wordsContainer[i];

//                 int p1 = s.length() - 1;
//                 int p2 = w.length() - 1;

//                 int common = 0;

//                 // count common suffix length
//                 while (p1 >= 0 && p2 >= 0 &&
//                         s.charAt(p1) == w.charAt(p2)) {

//                     common++;
//                     p1--;
//                     p2--;
//                 }

//                 // better suffix found
//                 if (common > longestSuffix) {
//                     longestSuffix = common;
//                     bestIndex = i;
//                 }

//                 // same suffix length
//                 else if (common == longestSuffix) {

//                     // choose smaller length word
//                     if (wordsContainer[i].length()
//                             < wordsContainer[bestIndex].length()) {

//                         bestIndex = i;
//                     }
//                 }
//             }

//             res[q] = bestIndex;
//         }

//         return res;
//     }
// }
class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];

        // best index for this suffix
        int idx = -1;

        // minimum length word
        int len = Integer.MAX_VALUE;
    }

    TrieNode root = new TrieNode();

    void insert(String word, int index) {

        TrieNode node = root;

        // update root info
        if (word.length() < node.len) {
            node.len = word.length();
            node.idx = index;
        }

        for (int i = word.length() - 1; i >= 0; i--) {

            char ch = word.charAt(i);
            int c = ch - 'a';

            if (node.child[c] == null) {
                node.child[c] = new TrieNode();
            }

            node = node.child[c];

            // keep shortest length word index
            if (word.length() < node.len) {
                node.len = word.length();
                node.idx = index;
            }
        }
    }

    int search(String word) {

        TrieNode node = root;

        for (int i = word.length() - 1; i >= 0; i--) {

            char ch = word.charAt(i);
            int c = ch - 'a';

            if (node.child[c] == null) {
                break;
            }

            node = node.child[c];
        }

        return node.idx;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        // build trie
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
        }

        int[] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(wordsQuery[i]);
        }

        return ans;
    }
}