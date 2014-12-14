package bestTimeToBuyAndSellStockIII;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p/>
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * <p/>
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int[] max = new int[prices.length];
        max[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            max[i] = max[i - 1] + prices[i] - prices[i - 1];
            if (max[i] < 0) {
                max[i] = 0;
            }
        }

        int maxProfit = max[prices.length - 1];
        // m1 : buy at i, the max profit make.
        // m2 : buy after i, the max profit make.
        int m1 = 0, m2 = 0;
        for (int i = prices.length - 2; i >= 0; i--) {
            if (m1 + prices[i + 1] - prices[i] >= 0) {
                m1 += prices[i + 1] - prices[i];
            } else {
                m1 = 0;
            }

            if (m1 > m2) {
                m2 = m1;
            }

            if (max[i] + m2 > maxProfit) {
                maxProfit = max[i] + m2;
            }
        }
        return maxProfit;
    }

    @Test
    public void test() {
        assertEquals(6, maxProfit(new int[]{10000, 9999, 9998, 10001, 10002, 9995, 9994, 9993, 9992, 9991, 9990, 9989, 9988, 9987, 9986, 9985, 9984, 9983, 9985}));
    }
}
