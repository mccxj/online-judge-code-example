package maxPointsOnALine;

import java.util.*;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        Arrays.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.y - o2.y;
            }
        });

        Map<String, Set<Point>> lines = new HashMap<String, Set<Point>>();
        int a, b, c;
        for (int i = 0; i < points.length; i++) {
            Point p1 = points[i];
            for (int j = i + 1; j < points.length; j++) {
                Point p2 = points[j];
                if (p1.x == p2.x && p1.y == p2.y) {
                    continue;
                } else if (p1.x == p2.x && p1.y != p2.y) {
                    a = 1;
                    b = 0;
                    c = -p1.x;
                } else if (p1.x != p2.x && p1.y == p2.y) {
                    a = 0;
                    b = 1;
                    c = -p1.y;
                } else {
                    a = p2.y - p1.y;
                    b = p1.x - p2.x;
                    c = p2.x * p1.y - p2.y * p1.x;
                    int gcd = gcd(a, b, c);
                    a /= gcd;
                    b /= gcd;
                    c /= gcd;
                }
                String line = a + "=" + b + "=" + c;
                Set<Point> ps = lines.get(line);
                if (ps == null) {
                    ps = new HashSet<Point>();
                    lines.put(line, ps);
                }
                ps.add(p1);
                ps.add(p2);
            }
        }

        if (lines.isEmpty()) {
            return points.length;
        }
        int max = 0;
        for (Set<Point> v : lines.values()) {
            if (v.size() > max) {
                max = v.size();
            }
        }
        return max;
    }

    private int gcd(int a, int b, int c) {
        int t = Math.abs(b);
        int gcd = a > t ? gcd(a, t) : gcd(t, a);
        if (c != 0) {
            t = Math.abs(c);
            gcd = gcd > t ? gcd(gcd, t) : gcd(t, gcd);
        }
        return gcd;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}