class Robot {
    int w, h, x, y, dir;
    String[] d = {"East", "North", "West", "South"};

    public Robot(int width, int height) {
        w = width; h = height;
        x = 0; y = 0; dir = 0;
    }

    public void step(int num) {
        int cycle = 2 * (w + h) - 4;
        num %= cycle;

        if (num == 0) {
            if (x == 0 && y == 0) dir = 3;
            return;
        }

        while (num > 0) {
            if (dir == 0) {
                int move = Math.min(num, w - 1 - x);
                x += move; num -= move;
                if (move == 0) dir = 1;
            } else if (dir == 1) {
                int move = Math.min(num, h - 1 - y);
                y += move; num -= move;
                if (move == 0) dir = 2;
            } else if (dir == 2) {
                int move = Math.min(num, x);
                x -= move; num -= move;
                if (move == 0) dir = 3;
            } else {
                int move = Math.min(num, y);
                y -= move; num -= move;
                if (move == 0) dir = 0;
            }
        }
    }

    public int[] getPos() { return new int[]{x, y}; }
    public String getDir() { return d[dir]; }
}