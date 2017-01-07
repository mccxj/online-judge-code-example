package org.poj;

import java.util.Scanner;

/**
 * Filling Out the Team(http://poj.org/problem?id=2070)
 * <p/>
 * <p/>
 * 简单数学题,不解释
 */
public class Main2070 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        double speed, weight, strength;

        while (true) {
            speed = cin.nextDouble();
            weight = cin.nextDouble();
            strength = cin.nextDouble();

            if (speed == 0 && weight == 0 && strength == 0)
                break;

            boolean found = false;
            if (speed <= 4.5 && weight >= 150 && strength >= 200) {
                System.out.print("Wide Receiver");
                found = true;
            }
            if (speed <= 6.0 && weight >= 300 && strength >= 500) {
                if (found)
                    System.out.print(' ');
                System.out.print("Lineman");
                found = true;
            }
            if (speed <= 5.0 && weight >= 200 && strength >= 300) {
                if (found)
                    System.out.print(' ');
                System.out.print("Quarterback");
                found = true;
            }
            if (!found)
                System.out.print("No positions");
            System.out.println();
        }
    }
}
