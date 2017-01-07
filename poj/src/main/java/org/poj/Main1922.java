package org.poj;

import java.util.Scanner;

/**
 * Ride to School(http://poj.org/problem?id=1922)
 * <p/>
 * <p/>
 * 数学题,不要纠结于速度,关注时间即可,Charley总是最早到学校,所有人到校的时间(除了提前出发的)
 */
public class Main1922 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int n, speed, time;
        int arrvial, min;
        while ((n = cin.nextInt()) != 0) {
            min = Integer.MAX_VALUE;
            while (n-- > 0) {
                speed = cin.nextInt();
                time = cin.nextInt();
                //提前出发的,要么就早到,要么会被追上,所以可以忽略
                if (time >= 0) {
                    arrvial = (int) Math.ceil((4.5 / speed) * 3600 + time);
                    if (arrvial < min)
                        min = arrvial;
                }
            }
            System.out.println(min);
        }
    }
}