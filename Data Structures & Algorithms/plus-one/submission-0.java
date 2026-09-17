class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> res = new ArrayList<>();
        int carry = 1;
        int i = digits.length - 1;
        int digit = 0;
        while (i >= 0 || carry == 1) {
            if (i >= 0)
                digit = digits[i] + carry;
            else
                digit = carry;
            if (digit % 10 == 0) {
                carry = digit / 10;
            } else {
                carry = 0;
            }
            res.add(digit % 10);
            i--;
        }
        Collections.reverse(res);
        int[] r = new int[res.size()];
        for (int j = 0; j < res.size(); j++) {
            r[j] = res.get(j);
        }
        return r;
    }
}
