class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int clone[] = arr.clone();
        Arrays.sort(clone);

        HashMap<Integer, Integer> hm = new HashMap<>();
        int rank = 1;

        for (int i = 0; i < clone.length; i++) {
            if (!hm.containsKey(clone[i])) {
                hm.put(clone[i], rank++);
            }
        }

        int res[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            res[i] = hm.get(arr[i]);
        }

        return res;
    }
}