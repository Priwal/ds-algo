class Solution {
    // Function to find minimum time required to rot all oranges.

    static class cell {
        int x;
        int y;

        cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public boolean isValid(int i, int j, int R, int C, int[][] grid) {
        if (i >= 0 && i < R && j >= 0 && j < C && grid[i][j] == 1)
            return true;
        else
            return false;
    }

    public boolean delim(cell item) {
        return (item.x == -1 && item.y == -1);
    }

    public int orangesRotting(int[][] grid) {
        // Code here
        int m = grid.length;
        int n = grid[0].length;

        boolean changed = false;
        Queue<cell> rotten = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {

                    rotten.add(new cell(i, j));

                }
            }
        }
        // add delimiter
        rotten.add(new cell(-1, -1));
        int time = 0;
        while (!rotten.isEmpty()) {
            boolean flag = false;

            while (!delim(rotten.peek())) {
                cell temp = rotten.peek();

                if (isValid(temp.x - 1, temp.y, m, n, grid)) {
                    if (!flag) {
                        time++;
                        flag = true;
                    }
                    grid[temp.x - 1][temp.y] = 2;// rot this current orange
                    rotten.add(new cell(temp.x - 1, temp.y));
                }

                if (isValid(temp.x + 1, temp.y, m, n, grid)) {
                    if (!flag) {
                        time++;
                        flag = true;
                    }
                    grid[temp.x + 1][temp.y] = 2;// rot this current orange
                    rotten.add(new cell(temp.x + 1, temp.y));
                }

                if (isValid(temp.x, temp.y - 1, m, n, grid)) {
                    if (!flag) {
                        time++;
                        flag = true;
                    }
                    grid[temp.x][temp.y - 1] = 2;// rot this current orange
                    rotten.add(new cell(temp.x, temp.y - 1));
                }

                if (isValid(temp.x, temp.y + 1, m, n, grid)) {
                    if (!flag) {
                        time++;
                        flag = true;
                    }
                    grid[temp.x][temp.y + 1] = 2;// rot this current orange
                    rotten.add(new cell(temp.x, temp.y + 1));
                }
                rotten.remove();
            }
            rotten.remove();
            if (!rotten.isEmpty()) {
                rotten.add(new cell(-1, -1));
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1)
                    return -1;
            }
        }

        return time;

    }
}