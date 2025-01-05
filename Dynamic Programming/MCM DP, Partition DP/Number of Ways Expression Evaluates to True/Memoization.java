class Solution {
    static int MOD = 1000000007;

    static long solve(char[] exp, int i, int j, int isTrue, Long[][][] dp) {
        if (i == j) {
            if (isTrue == 1)
                return exp[i] == 'T' ? 1 : 0;
            return exp[i] == 'F' ? 1 : 0;
        }

        if (dp[i][j][isTrue] != null)
            return dp[i][j][isTrue];

        long ways = 0;
        for (int k = i + 1; k <= j - 1; k += 2) {
            long leftT = solve(exp, i, k - 1, 1, dp);
            long leftF = solve(exp, i, k - 1, 0, dp);
            long rightT = solve(exp, k + 1, j, 1, dp);
            long rightF = solve(exp, k + 1, j, 0, dp);

            switch (exp[k]) {
                case '|':
                    ways += (isTrue == 1 ? leftT * rightT + leftT * rightF + leftF * rightT : leftF * rightF) % MOD;
                    break;
                case '&':
                    ways += (isTrue == 1 ? leftT * rightT : leftT * rightF + leftF * rightT + leftF * rightF) % MOD;
                    break;
                case '^':
                    ways += (isTrue == 1 ? leftT * rightF + leftF * rightT : leftT * rightT + leftF * rightF) % MOD;
            }
        }
        return dp[i][j][isTrue] = ways % MOD;
    }

    public static int evaluateExp(String exp) {
        char[] expr = exp.toCharArray();
        int N = expr.length;
        Long[][][] dp = new Long[N][N][2];
        return (int) solve(expr, 0, N - 1, 1, dp);
    }
}