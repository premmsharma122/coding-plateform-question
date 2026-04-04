class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1) return encodedText;
        int n = encodedText.length();
        int cols = n / rows;
        char[][] g = new char[rows][cols];

        int idx = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                g[i][j] = encodedText.charAt(idx++);
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int j = 0; j < cols; j++) {
            int i = 0, k = j;
            while (i < rows && k < cols) {
                sb.append(g[i][k]);
                i++;
                k++;
            }
        }

        int end = sb.length() - 1;
        while (end >= 0 && sb.charAt(end) == ' ') {
            end--;
        }

        return sb.substring(0, end + 1);
    }
}