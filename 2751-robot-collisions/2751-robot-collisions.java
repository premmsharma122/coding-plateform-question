class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String dir) {
        int n = positions.length;
        int rob[][] = new int[positions.length][4];
        for(int i=0; i<positions.length; i++){
            rob[i][0] = positions[i];
            rob[i][1] = healths[i];
            rob[i][2]= dir.charAt(i);
            rob[i][3] = i;
        }
        Arrays.sort(rob,(a,b)->a[0]-b[0]);
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
    if(rob[i][2] == 'R'){
        st.push(i);
    } else {
        while(!st.isEmpty() && rob[i][1] > 0){
            int j = st.peek();

            if(rob[i][1] > rob[j][1]){
                rob[j][1] = 0;
                rob[i][1]--;
                st.pop();
            } 
            else if(rob[i][1] < rob[j][1]){
                rob[j][1]--;
                rob[i][1] = 0;
                break;
            } 
            else {
                rob[j][1] = 0;
                rob[i][1] = 0;
                st.pop();
                break;
            }
        }
    }
}
         int[] result = new int[n];
        Arrays.fill(result, -1);

        for (int i = 0; i < n; i++) {
            if (rob[i][1] > 0) {
                int idx = rob[i][3];
                result[idx] = rob[i][1];
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int x : result) {
            if (x != -1) ans.add(x);
        }

        return ans;
    }
}