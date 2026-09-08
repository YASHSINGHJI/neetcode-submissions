class Solution {
    public int countSubstrings(String s) {
        int res=0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int maxlen = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    res++;
                    int len = j - i + 1;
                    if (len > maxlen) {
                        maxlen = len;
                        start = i;
                    }
                }
            }
        }
        return res;
    }
}
