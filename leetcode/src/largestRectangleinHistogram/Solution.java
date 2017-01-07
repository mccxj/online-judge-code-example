package largestRectangleinHistogram;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * <p/>
 * <p/>
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * <p/>
 * <p/>
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * <p/>
 * For example,
 * Given height = [2,1,5,6,2,3],
 * return 10.
 */
public class Solution {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int max = 0;
        height = Arrays.copyOf(height, height.length + 1);
        height[height.length - 1] = 0;
        Stack<Integer> poses = new Stack<Integer>();
        poses.add(0);

        for (int i = 1; i < height.length; i++) {
            int h = height[i];
            while (!poses.isEmpty() && h <= height[poses.peek()]) {
                int pos = poses.pop();
                int rect = height[pos] * (i - pos);

                if (poses.isEmpty()) {
                    rect += height[pos] * pos;
                } else {
                    rect += height[pos] * (pos - poses.peek() - 1);
                }

                if (rect > max) {
                    max = rect;
                }
            }
            poses.add(i);
        }
        return max;
    }
}
