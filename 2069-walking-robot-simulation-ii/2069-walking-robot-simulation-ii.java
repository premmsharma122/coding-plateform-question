class Robot {
    int width, height;
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}}; // East, North, West, South
    int d = 0, x = 0, y = 0;
    int p;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.p = 2 * (width + height) - 4;
    }

    public void step(int num) {
        num %= p;
        if(num == 0 && p > 0) num = p;  // full cycle fix

        for(int i = 0; i < num; i++) {
            int nx = x + dir[d][0];
            int ny = y + dir[d][1];

            if(nx < 0 || nx >= width || ny < 0 || ny >= height) {
                d = (d + 1) % 4;
                i--;
            } else {
                x = nx;
                y = ny;
            }
        }
    }

    public int[] getPos() {
        return new int[]{x, y};
    }

    public String getDir() {
        if(d == 0) return "East";
        if(d == 1) return "North";
        if(d == 2) return "West";
        return "South";
    }
}