class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Queue<String[]> queue = new LinkedList<>();
        queue.offer(new String[]{beginWord, "1"});

        Set<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord))
            return 0;

        while (!queue.isEmpty()) {

            String[] node = queue.poll();
            String word = node[0];
            int level = Integer.parseInt(node[1]);

            List<String> remove = new ArrayList<>();

            for (String s : set) {

                if (error(s, word) == 1) {

                    if (s.equals(endWord))
                        return level + 1;

                    queue.offer(new String[]{s, String.valueOf(level + 1)});
                    remove.add(s);
                }
            }

            // Remove after iteration
            for (String s : remove)
                set.remove(s);
        }

        return 0;
    }

    public int error(String a1, String a2) {
        int e = 0;
        for (int i = 0; i < a1.length(); i++) {
            if (a1.charAt(i) != a2.charAt(i))
                e++;
        }
        return e;
    }
}