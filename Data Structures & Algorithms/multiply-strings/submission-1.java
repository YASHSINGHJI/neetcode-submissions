class Solution {
    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        for (int i1 = 0; i1 < num1.length(); i1++) {
            for (int i2 = 0; i2 < num2.length(); i2++) {
                int digit1 = num1.charAt(i1) - '0';
                int digit2 = num2.charAt(i2) - '0';
                int mul = digit1 * digit2;
                res[i1 + i2] += mul;
                res[i1 + i2 + 1] += res[i1 + i2] / 10;
                res[i1 + i2] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = res.length - 1;

        while (i >= 0 && res[i] == 0) i--;

        while (i >= 0) sb.append(res[i--]);

        return sb.toString();
    }
}
