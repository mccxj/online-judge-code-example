package org.poj;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Bode Plot(http://poj.org/problem?id=1045)
 * 
 * <p>
 * 公式推导：<br/>
 * V2=iR=CR d/dt(Vs*cos(wt)-Vr*cos(wt+b))=Vrcos(wt+b)<br/>
 * CRw(sin(wt+b)-sin(wt))=Vr*cos(wt+b)<br/>
 * 令t=0化简得： tan(b)=1/(CRw)-------------(1)<br/>
 * 令wt+b=0化简得：Vr=CRwVs*sin(b)------------(2)<br/>
 * 由(1),(2)得： Vr=CRwVs/sqrt(1+(CRw)^2))
 */
public class Main1045 {
    public static void main(String args[]) {
        DecimalFormat format = new DecimalFormat("0.000");

        Scanner cin = new Scanner(System.in);
        double vs = cin.nextDouble();
        double r = cin.nextDouble();
        double c = cin.nextDouble();
        int t = cin.nextInt();
        while (t-- > 0) {
            double w = cin.nextDouble();
            double vr = c * r * w * vs / Math.sqrt(1 + c * r * w * c * r * w);
            System.out.println(format.format(vr));
        }
    }
}