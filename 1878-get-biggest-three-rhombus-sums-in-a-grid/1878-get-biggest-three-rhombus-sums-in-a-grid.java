class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int m =grid.length, n = grid[0].length;
        HashSet<Integer> st = new HashSet<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                for(int d=0; d<26; d++){
                    if(i-d<0 || j-d<0 || i+d>=m || j+d>=n) break;
                    int sum=0;
                    if(d==0) sum=grid[i][j];
                    else{
                        sum+=grid[i-d][j] +grid[i+d][j]+grid[i][j-d]+grid[i][j+d];
                        for(int t=1; t<d; t++){
                            sum+=grid[i+t][j+d-t];
                            sum+=grid[i+t][j-d+t];
                            sum+=grid[i-t][j+d-t];
                            sum+=grid[i-t][j-d+t];
                        }
                    }
                    st.add(sum);
                }
            }
        }
        List<Integer> li = new ArrayList<>(st);
        Collections.sort(li,Collections.reverseOrder());
        int k = Math.min(3,li.size());
        int ans[] = new int[k];
        for(int i=0; i<k; i++){
            ans[i] = li.get(i);
        }
        return ans;
    }
}