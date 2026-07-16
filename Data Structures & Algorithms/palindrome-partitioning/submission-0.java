class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> str = new ArrayList<>();
        backtrack(s, str, new ArrayList<>(), 0);
        return str;
    }

    public void backtrack(String s, List<List<String>> str, List<String> list, int i) {
        if (i >= s.length()) {
            str.add(new ArrayList<>(list));
            return;
        }
        for (int index = i; index < s.length(); index++) {
            if (Palindrome(s, i, index)) {
                list.add(s.substring(i, index + 1));
                backtrack(s, str, list, index + 1);
                list.remove(list.size() - 1);
            }
        }

    }

    public boolean Palindrome(String s, int i, int j) {
        boolean flag = false;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
