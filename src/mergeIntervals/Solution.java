package mergeIntervals;

import org.junit.Test;

import java.util.*;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * <p/>
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> inters = new ArrayList<Interval>();
        if (intervals == null || intervals.isEmpty()) {
            return inters;
        }

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

    @Test
    public void test() {
        List<Interval> intervals = new ArrayList<Interval>();
        //[1,3],[2,6],[8,10],[15,18],
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(15, 18));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        List<Interval> merge = merge(intervals);

    }
}
