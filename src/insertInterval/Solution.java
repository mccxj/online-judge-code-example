package insertInterval;

import java.util.*;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p/>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p/>
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * <p/>
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * <p/>
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> inters = new ArrayList<Interval>();
        intervals.add(newInterval);

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        Iterator<Interval> it = intervals.iterator();
        Interval tmp = it.next();
        while (it.hasNext()) {
            Interval next = it.next();
            if (next.start <= tmp.end) {
                tmp = new Interval(tmp.start, Math.max(tmp.end, next.end));
            } else {
                inters.add(tmp);
                tmp = next;
            }
        }
        inters.add(tmp);
        return inters;
    }
}
