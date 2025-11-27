public class Code {
    
}



class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int MOD = 1_000_000_007;

        // dp[j][r] = number of ways to reach cell in current row column j with sum%k=r
        int[][] dp = new int[n][k];

        // Initialize first cell
        dp[0][grid[0][0] % k] = 1;

        for (int i = 0; i < m; i++) {
            int[][] newDp = new int[n][k];

            for (int j = 0; j < n; j++) {
                int val = grid[i][j];

                for (int r = 0; r < k; r++) {
                    int newR = (r + val) % k;

                    // from left
                    if (j > 0) {
                        newDp[j][newR] = (newDp[j][newR] + newDp[j - 1][r]) % MOD;
                    }

                    // from top (previous dp values)
                    if (i > 0) {
                        newDp[j][newR] = (newDp[j][newR] + dp[j][r]) % MOD;
                    }
                }

                // special case for (0,0), already initialized above
                if (i == 0 && j == 0) {
                    newDp[0][grid[0][0] % k] = 1;
                }
            }

            dp = newDp; // move to next row
        }

        return dp[n - 1][0];
    }
}

