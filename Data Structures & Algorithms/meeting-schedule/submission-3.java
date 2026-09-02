/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return true;
        }
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        boolean flag = true;
        int prevEnd = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < prevEnd) {
                flag = false;
                return flag;
            } else {
                prevEnd = intervals.get(i).end;
            }
        }
        return flag;
    }
}
