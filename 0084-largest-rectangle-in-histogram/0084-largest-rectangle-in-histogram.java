class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxA = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<=heights.length; i++){
           int currH = (i==heights.length) ? 0 : heights[i];

           while(!st.isEmpty() && currH < heights[st.peek()]){
                int hei = heights[st.pop()];
                int wed = st.isEmpty() ? i : i - st.peek() -1;
                maxA = Math.max(maxA, hei * wed);

            }
            st.push(i);

        }
            return maxA;
        }
    }
