import java.util.ArrayList;

class Solution {
    public int flip(int num){
        if (num == 0) {
            return 1;
        }
        
        ArrayList<Integer> arr = new ArrayList<>();
        while (num > 0) {
            int r = num % 2;
            if(r==1){
                 arr.add(0);
            }
            else if(r==0){
                arr.add(1);
            }
            num = num / 2;
        }
        
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i) * (int) Math.pow(2, i);
        }
        
        return sum;
    }

    public int bitwiseComplement(int n) {
        return flip(n);
    }
}