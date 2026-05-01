// class Solution {
//     public void swap(int[] nums, int k) {
//         int n = nums.length;
//         k = k % n;
//         reverse(nums, 0, n - 1);
//         reverse(nums, 0, k - 1);
//         reverse(nums, k, n - 1);
//     }

//     public void reverse(int[] arr, int start, int end) {
//         while (start < end) {
//             int temp = arr[start];
//             arr[start] = arr[end];
//             arr[end] = temp;
//             start++;
//             end--;
//         }
//     }

//     public int help(int arr[]) {
//         int c = 0;
//         for (int i = 0; i < arr.length; i++) {
//             c += (i * arr[i]);
//         }
//         return c;
//     }

//     public int maxRotateFunction(int[] nums) {
//         int n = nums.length;
//         int max = Integer.MIN_VALUE;
//         int[] original = nums.clone();
//         for (int i = 0; i < n; i++) {
//             int[] temp = original.clone();
//             swap(temp, i);
//             int cal = help(temp);
//             max = Math.max(max, cal);
//         }
//         return max;
//     }
// }
class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int f = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            f += i * nums[i];
        }

        int max = f;

        for (int k = 1; k < n; k++) {
            f = f + sum - n * nums[n - k];
            max = Math.max(max, f);
        }

        return max;
    }
}