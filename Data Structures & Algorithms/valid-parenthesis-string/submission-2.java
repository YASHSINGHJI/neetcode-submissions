class Solution {
    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                low = Math.max(0, low - 1); // low cannot drop below 0
                high--;
            } else if (c == '*') {
                low = Math.max(0, low - 1); // treating * as ')' or empty
                high++;                     // treating * as '('
            }

            // If max possible '(' is negative, we have too many close brackets ')'
            if (high < 0) {
                return false;
            }
        }

        // If minimum required open brackets is 0, the string is valid
        return low == 0;
    }
}
