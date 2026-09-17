class Solution {
    public double myPow(double x, int n) {
        if (x == 0)
            return 0;
        if (n == 0)
            return 1;
        double res = solve(x, Math.abs(n));
        return (n >= 0) ? res : (1 / res);
    }
    public double solve(double x, int n) {
        if (n == 0)
            return 1;
        double half = solve(x, n / 2);
        return (n % 2 == 0) ? half * half : x * half * half;
    }
}
