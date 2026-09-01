class Solution {

    public int[][] merge(int[][] intervals) {

        List<int[]> res = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            // Overlap
            if (intervals[i][0] <= end) {

                end = Math.max(end, intervals[i][1]);

            } else {

                // No overlap
                res.add(new int[]{start, end});

                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        // Add final interval
        res.add(new int[]{start, end});

        return res.toArray(new int[res.size()][]);
    }
}