package org.poj;

/**
 * Specialized Four-Digit Numbers(http://poj.org/problem?id=2196)
 * <p/>
 * <p/>
 * 进制计算,简单题
 */
public class Main2196 {
    public static void main(String args[]) {

        for (int i = 2992; i < 10000; i++) {
            int sum = getSum(i, 10);
            if (sum == getSum(i, 12) && sum == getSum(i, 16))
                System.out.println(i);
        }
    }

    public static int getSum(int num, int radix) {
        int sum = 0;
        while (num != 0) {
            sum -= num % radix;
            num /= radix;
        }
        return sum;
    }
}