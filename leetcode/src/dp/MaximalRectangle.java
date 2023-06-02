package dp;


public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        String str = "Fafda";

        int[][] dp = new int[row][col];
        int ans = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 && j == 0) {
                        dp[i][j] = 1;
                    } else if (i == 0) {
                        dp[i][j] = 1 + dp[i][j - 1];
                    } else if (j == 0) {
                        dp[i][j] = 1 + dp[i - 1][j];
                    } else {
                        if (matrix[i - 1][j] == '1' && matrix[i][j - 1] == '1' && matrix[i - 1][j - 1] == '1') {
                            dp[i][j] = 1 + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
                        } else if (matrix[i - 1][j] == '1' || matrix[i][j - 1] == '1') {
                            dp[i][j] = 1 + Math.max(dp[i - 1][j], dp[i][j - 1]) - (matrix[i - 1][j - 1] == '1' ? dp[i - 1][j - 1] : 0);
                        } else {
                            dp[i][j] = 1;
                        }
                    }
                }

                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
