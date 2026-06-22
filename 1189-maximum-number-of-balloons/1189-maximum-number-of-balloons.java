class Solution {
    public int maxNumberOfBalloons(String text) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i=0; i<text.length(); i++){
            hm.put(text.charAt(i), hm.getOrDefault(text.charAt(i),0)+1);
        }
        int minBalloons = Integer.MAX_VALUE;
        minBalloons = Math.min(minBalloons, hm.getOrDefault('b', 0) / 1);
        minBalloons = Math.min(minBalloons, hm.getOrDefault('a', 0) / 1);
        minBalloons = Math.min(minBalloons, hm.getOrDefault('l', 0) / 2);
        minBalloons = Math.min(minBalloons, hm.getOrDefault('o', 0) / 2);
        minBalloons = Math.min(minBalloons, hm.getOrDefault('n', 0) / 1);

        return minBalloons;
    }
}