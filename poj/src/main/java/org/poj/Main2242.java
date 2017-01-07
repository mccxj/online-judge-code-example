package org.poj;

import java.util.Scanner;

/**
 * The Circumference of the Circle(http://poj.org/problem?id=2242)
 * <p/>
 * <p/>
 * 数学题,由三点定位圆心,求周长
 * （x-x1)^2+(y-y1)^2=(x-x2)^2+(y-y2)^2 => 2(x1-x2)*x+2(y1-y2)y=x1^2+y1^2-x2^2-y2^2
 * （x-x1)^2+(y-y1)^2=(x-x3)^2+(y-y3)^2 => 2(x1-x3)*x+2(y1-y3)y=x1^2+y1^2-x3^2-y3^2
 * 2(x1-x2)(y1-y3)*x+2(y1-y2)(y1-y3)y=(x1^2+y1^2-x2^2-y2^2)*(y1-y3)
 * 2(y1-y2)(x1-x3)*x+2(y1-y2)(y1-y3)y=(x1^2+y1^2-x3^2-y3^2)*(y1-y2)
 * <p/>
 * x = ((x1^2+y1^2-x2^2-y2^2)*(y1-y3) - (x1^2+y1^2-x3^2-y3^2)*(y1-y2))/2*((x1-x2)(y1-y3)-(y1-y2)(x1-x3))
 */
public class Main2242 {
    public static void main(String args[]) {
        double x1, x2, x3, y1, y2, y3, x, y;
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            x1 = cin.nextDouble();
            y1 = cin.nextDouble();
            x2 = cin.nextDouble();
            y2 = cin.nextDouble();
            x3 = cin.nextDouble();
            y3 = cin.nextDouble();

            x = ((x1 * x1 + y1 * y1 - x2 * x2 - y2 * y2) * (y1 - y3) - (x1 * x1 + y1 * y1 - x3 * x3 - y3 * y3) * (y1 - y2)) /
                    (2 * ((x1 - x2) * (y1 - y3) - (y1 - y2) * (x1 - x3)));
            if (y1 != y2) {
                y = (x1 * x1 + y1 * y1 - x2 * x2 - y2 * y2 - 2 * (x1 - x2) * x) / (2 * (y1 - y2));
            } else if (y1 != y3) {
                y = (x1 * x1 + y1 * y1 - x3 * x3 - y3 * y3 - 2 * (x1 - x3) * x) / (2 * (y1 - y3));
            } else {
                y = (x2 * x2 + y2 * y2 - x3 * x3 - y3 * y3 - 2 * (x2 - x3) * x) / (2 * (y2 - y3));
            }

            double c = 2 * Math.PI * Math.sqrt((x - x1) * (x - x1) + (y - y1) * (y - y1));
            System.out.printf("%.2f", c);
            System.out.println();
        }
    }
}