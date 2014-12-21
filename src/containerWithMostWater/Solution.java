package containerWithMostWater;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p/>
 * Note: You may not slant the container.
 */
public class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        if (height == null || height.length < 2) {
            return max;
        }

        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int tmax = (right - left) * Math.min(height[left], height[right]);
            if (tmax > max) {
                max = tmax;
            }

            if (height[left] < height[right]) {
                int t = left;
                while (t < right && height[t] <= height[left]) {
                    t++;
                }
                left = t;
            } else {
                int t = right;
                while (t > left && height[t] <= height[right]) {
                    t--;
                }
                right = t;
            }
        }

        return max;
    }

    @Test
    public void test() {
        assertEquals(0, maxArea(new int[]{1}));
        assertEquals(1, maxArea(new int[]{1, 2}));
        assertEquals(3, maxArea(new int[]{1, 5, 3}));
        assertEquals(5, maxArea(new int[]{1, 5, 6, 2}));
    }
}