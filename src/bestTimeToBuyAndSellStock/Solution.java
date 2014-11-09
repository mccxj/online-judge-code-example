package bestTimeToBuyAndSellStock;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p/>
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] max = new int[prices.length];
        max[0] = 0;
        int m = 0;
        for (int i = 1; i < prices.length; i++) {
            max[i] = max[i - 1] + prices[i] - prices[i - 1];
            if (max[i] < 0) {
                max[i] = 0;
            }
            if (max[i] > m) {
                m = max[i];
            }
        }
        return m;
    }
}
