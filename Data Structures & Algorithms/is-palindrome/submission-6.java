class Solution {
       public boolean isPalindrome(String s) {
        String fin = helper(s);
        int start = 0;
        int end = fin.length() - 1;
        while (start <= end) {
            if (fin.charAt(start) != fin.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;

    }

    public String helper(String s) {
        char[] ch = s.toCharArray();
        StringBuilder res = new StringBuilder();
        for (char c : ch) {
            if (Character.isLetterOrDigit(c)) {
                res.append(c);
            }
        }
        return res.toString().toLowerCase();
    }
}
