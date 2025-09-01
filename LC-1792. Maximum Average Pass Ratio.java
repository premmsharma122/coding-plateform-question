class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
          PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            double gainA = ((double)(a[0] + 1) / (a[1] + 1)) - ((double) a[0] / a[1]);
            double gainB = ((double)(b[0] + 1) / (b[1] + 1)) - ((double) b[0] / b[1]);
            return Double.compare(gainB, gainA); 
        });

        for(int a[] : classes ){
            pq.offer(a);
        }

        while(extraStudents-->0){
            int ar[] = pq.poll();
            ar[0]+=1;
            ar[1]+=1;
            pq.add(ar);
        }

        double ans = 0.0;
        for(int a[] : pq){
            ans +=(double) a[0]/a[1];
        }
        return ans/classes.length;

    }
}
