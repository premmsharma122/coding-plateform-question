import java.util.*;

class Solution {
    public int help(int nums[] ,int st, int end, int x){
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = st; i <= end; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hm.entrySet());
        list.sort((a, b) -> {
            if(a.getValue().equals(b.getValue())) 
                return b.getKey() - a.getKey();
            return b.getValue() - a.getValue();
        });

        int c = 0, sum = 0;
        for(Map.Entry<Integer, Integer> e : list){
            if(c < x){
                sum += e.getKey() * e.getValue();
                c++;
            } else break;
        }
        return sum;
    }

    public int[] findXSum(int[] nums, int k, int x) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i + k - 1 < nums.length; i++){
            int a = help(nums, i, i + k - 1, x);
            arr.add(a);
        }

        int ans[] = new int[arr.size()];
        int idx = 0;
        for(int a : arr){
            ans[idx++] = a;
        }
        return ans;
    }
}
