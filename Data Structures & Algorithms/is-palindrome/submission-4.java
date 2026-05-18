class Solution {
   public boolean isPalindrome(String s) {

    String str = s.toLowerCase();

    int start = 0;
    int end = str.length() - 1;

    while (start < end) {

        // Skip non-alphanumeric from left
        while (start < end && !Character.isLetterOrDigit(str.charAt(start))) {
            start++;
        }

        // Skip non-alphanumeric from right
        while (start < end && !Character.isLetterOrDigit(str.charAt(end))) {
            end--;
        }

        // Compare characters
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        start++;
        end--;
    }

    return true;
}
}
