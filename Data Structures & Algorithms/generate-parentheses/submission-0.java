class Solution {
     public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        String str = "";
        return generateParenthesisHelper(n, n, str, result);
            
            
        }
        public List<String> generateParenthesisHelper(int left, int right, String str, List<String> result) {
            if (left == 0 && right == 0) {
                result.add(str);
                return result;
            }
            if (left > 0) {
                generateParenthesisHelper(left - 1, right, str + "(", result);
            }
            if (right > left) {
                generateParenthesisHelper(left, right - 1, str + ")", result);
            }

        return result;

        
    }

}
