class Solution {
    static int MOD = 1000000007;

    public static int evaluateExp(String exp) {
        char[] expr = exp.toCharArray();
        int N = expr.length;
        long[][][] dp = new long[N][N][2];

        for (int i = 0; i < N; i += 2) {
            dp[i][i][1] = expr[i] == 'T' ? 1 : 0;
            dp[i][i][0] = expr[i] == 'F' ? 1 : 0;
        }

        for (int i = N - 1; i >= 0; --i) {
            for (int j = i + 1; j < N; ++j) {

                long waysT = 0, waysF = 0;
                for (int k = i + 1; k <= j - 1; k += 2) {
                    long leftT = dp[i][k - 1][1];
                    long leftF = dp[i][k - 1][0];
                    long rightT = dp[k + 1][j][1];
                    long rightF = dp[k + 1][j][0];

                    switch (expr[k]) {
                        case '|':
                            waysT += (leftT * rightT + leftT * rightF + leftF * rightT) % MOD;
                            waysF += (leftF * rightF) % MOD;
                            break;
                        case '&':
                            waysT += (leftT * rightT) % MOD;
                            waysF += (leftT * rightF + leftF * rightT + leftF * rightF) % MOD;
                            break;
                        case '^':
                            waysT += (leftT * rightF + leftF * rightT) % MOD;
                            waysF += (leftT * rightT + leftF * rightF) % MOD;
                    }
                }
                dp[i][j][0] = waysF % MOD;
                dp[i][j][1] = waysT % MOD;
            }
        }

        return (int) dp[0][N - 1][1];
    }
}