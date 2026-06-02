class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration,
                                  int[] waterStartTime, int[] waterDuration) {

        int min = Integer.MAX_VALUE;
        int n = landStartTime.length;
        int m = waterStartTime.length;

        for (int i = 0; i < n; i++) {
            int landFinish = landStartTime[i] + landDuration[i];

            for (int j = 0; j < m; j++) {
                int waterStart = Math.max(landFinish, waterStartTime[j]);
                int finishTime = waterStart + waterDuration[j];

                min = Math.min(min, finishTime);
            }
        }

        for (int i = 0; i < m; i++) {
            int waterFinish = waterStartTime[i] + waterDuration[i];

            for (int j = 0; j < n; j++) {
                int landStart = Math.max(waterFinish, landStartTime[j]);
                int finishTime = landStart + landDuration[j];

                min = Math.min(min, finishTime);
            }
        }

        return min;
    }
}