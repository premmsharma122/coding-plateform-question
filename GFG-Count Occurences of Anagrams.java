// Optimized solution using sliding window + frequency arrays
class Solution {
    int search(String pat, String txt) {
        int n = txt.length();
        int m = pat.length();
        if (m > n) return 0;

        int[] patFreq = new int[26];
        int[] windowFreq = new int[26];

        
        for (char c : pat.toCharArray()) {
            patFreq[c - 'a']++;
        }

        int count = 0;

        
        for (int i = 0; i < m; i++) {
            windowFreq[txt.charAt(i) - 'a']++;
        }

        
        if (isSame(patFreq, windowFreq)) count++;

        
        for (int i = m; i < n; i++) {
            
            windowFreq[txt.charAt(i) - 'a']++;
            
            windowFreq[txt.charAt(i - m) - 'a']--;

            if (isSame(patFreq, windowFreq)) count++;
        }

        return count;
    }

    
    private boolean isSame(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
