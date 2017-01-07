package org.poj;

import java.util.Scanner;

/**
 * Biker's Trip Odometer(http://poj.org/problem?id=1665)
 * <p/>
 * 数学题,就是单位转换有点烦
 * For p use the value: 3.1415927.
 * There are 5280 feet in a mile.
 * There are 12 inches in a foot.
 * There are 60 minutes in an hour.
 * There are 60 seconds in a minute.
 * There are 201.168 meters in a furlong.
 */
public class Main1665 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        int trans = 12 * 5280;
        for (int n = 1; ; n++) {
            double diameter = cin.nextDouble();
            int revolutions = cin.nextInt();
            double time = cin.nextDouble();

            if (revolutions == 0)
                break;

            double distance = Math.PI * diameter * revolutions / trans;
            double mph = distance / time * 3600;
            System.out.printf("Trip #%d: %.2f %.2f", n, distance, mph);
            System.out.println();
        }
    }
}