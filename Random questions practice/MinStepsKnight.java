
//given starting pos and ending position of Knight on chess board, fin min steps 
//to reach from start to target

class Solution {

    class cell {
        int x;
        int y;
        int dist;

        cell(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static boolean isValid(int x, int y, boolean visited[][], int n) {
        return (x >= 1 && x <= n && y >= 1 && y <= n && visited[x][y] == false);
    }

    // Function to find out minimum steps Knight needs to reach target position.
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N) {
        // Code here
        int row[] = { -2, -1, 1, 2, -2, -1, 1, 2 };
        int col[] = { -1, -2, -2, -1, 1, 2, 2, 1 };

        boolean visited[][] = new boolean[N + 1][N + 1];

        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                visited[i][j] = false;

        visited[KnightPos[0]][KnightPos[1]] = true;

        Queue<cell> q = new LinkedList<>();
        q.add(new cell(KnightPos[0], KnightPos[1], 0));

        while (!q.isEmpty()) {

            cell currCell = q.poll();

            if (currCell.x == TargetPos[0] && currCell.y == TargetPos[1])
                return currCell.dist;

            for (int i = 0; i < 8; i++) {
                int tx = currCell.x + row[i];
                int ty = currCell.y + col[i];

                if (isValid(tx, ty, visited, N)) {
                    visited[tx][ty] = true;
                    q.add(new cell(tx, ty, currCell.dist + 1));

                }

            }

        }

        return Integer.MAX_VALUE;
    }
}