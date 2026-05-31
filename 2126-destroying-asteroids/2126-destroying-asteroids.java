class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        boolean arr[] = new boolean[asteroids.length];
        long a=mass;
        for(int i=0; i<asteroids.length; i++){
            if(a>=asteroids[i]){
                a+=asteroids[i];
            }else{
                return false;
            }
        }
        return true;
    }
}