class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        int i = n;
        while (i!=1) {
            int res = 0;
            if (set.contains(i)) {
                return false;
            }
            set.add(i);
            while (i != 0) {
                int digit = i % 10;
                res += Math.pow(digit, 2);
                i /= 10;
            }            
            i = res;
            
        }
        return true;

    }
}
