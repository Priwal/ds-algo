class Solution {
    static int maxSquare(int n, int m, int mat[][]) {
        // code here

        int s[][] = new int[n][m];

        // fill the first column as it is
        for (int i = 0; i < n; i++) {
            s[i][0] = mat[i][0];
        }

        // fill the first row as it is
        for (int i = 0; i < m; i++) {
            s[0][i] = mat[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] == 1) {
                    s[i][j] = Math.min(s[i - 1][j], Math.min(s[i][j - 1], s[i - 1][j - 1])) + 1;
                } else
                    s[i][j] = 0;
            }
        }
        int max_of_s = s[0][0], max_i = 0, max_j = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (s[i][j] >= max_of_s) {
                    max_of_s = s[i][j];

                }
            }
        }
        return max_of_s;

    }
}
