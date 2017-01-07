package org.poj;

import java.text.MessageFormat;
import java.util.Scanner;

/**
 * Humidex(http://poj.org/problem?id=3299)
 * 
 * <p>
 * 根据公式计算温度<br/>
 * humidex = temperature + h<br/>
 * h = (0.5555)× (e - 10.0)<br/>
 * e = 6.11 × exp [5417.7530 × ((1/273.16) - (1/(dewpoint+273.16)))]<br/>
 */
public class Main3299 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        MessageFormat mf = new MessageFormat("T {0,number,0.0} D {1,number,0.0} H {2,number,0.0}");
        String[] cmds = new String[2];// 保存输入的命令
        double[] ins = new double[2];// 保存输入的参数值
        while (!"E".equals(cmds[0] = cin.next())) {
            Double[] states = {Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE};// 用来保存t,d,h
            ins[0] = cin.nextDouble();
            cmds[1] = cin.next();
            ins[1] = cin.nextDouble();

            for (int i = 0; i < cmds.length; i++) {
                if ("T".equals(cmds[i])) {
                    states[0] = ins[i];
                } else if ("D".equals(cmds[i])) {
                    states[1] = ins[i];
                } else if ("H".equals(cmds[i])) {
                    states[2] = ins[i];
                }
            }

            if (states[0] == Double.MIN_VALUE) {// D,H -> T
                double e = 6.11 * Math.exp(5417.7530 * ((1 / 273.16) - (1 / (states[1] + 273.16))));
                states[0] = states[2] - 0.5555 * (e - 10.0);
            } else if (states[1] == Double.MIN_VALUE) {// T,H -> D
                double e = (states[2] - states[0]) / 0.5555 + 10.0;
                states[1] = 1 / ((1 / 273.16) - Math.log(e / 6.11) / 5417.7530) - 273.16;
            } else if (states[2] == Double.MIN_VALUE) {// T,D -> H
                double e = 6.11 * Math.exp(5417.7530 * ((1 / 273.16) - (1 / (states[1] + 273.16))));
                states[2] = states[0] + 0.5555 * (e - 10.0);
            }

            System.out.println(mf.format(states));
        }
    }
}