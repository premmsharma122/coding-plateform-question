import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Collections;

 class codeChef {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        
        int t = Integer.parseInt(tokenizer.nextToken());
        StringBuilder output = new StringBuilder();
        
        while (t-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int m = Integer.parseInt(tokenizer.nextToken());
            
            long[] a = new long[n];
            tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(tokenizer.nextToken());
            }
            
            if (m == 1) {
                long maxVal = a[0];
                for (int i = 1; i < n; i++) {
                    if (a[i] > maxVal) {
                        maxVal = a[i];
                    }
                }
                output.append(maxVal).append("\n");
                continue;
            }
            
            int k = m - 1;
            PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            long currentSum = 0;
            long maxScore = Long.MIN_VALUE;
            
            for (int j = 0; j < n; j++) {
                if (j >= k) {
                    long score = (long) m * a[j] - currentSum;
                    if (score > maxScore) {
                        maxScore = score;
                    }
                }
                
                if (maxHeap.size() < k) {
                    maxHeap.offer(a[j]);
                    currentSum += a[j];
                } else {
                    if (a[j] < maxHeap.peek()) {
                        long removed = maxHeap.poll();
                        currentSum -= removed;
                        maxHeap.offer(a[j]);
                        currentSum += a[j];
                    }
                }
            }
            
            output.append(maxScore).append("\n");
        }
        
        System.out.print(output);
    }
    20
34
10
15
7
108

}
