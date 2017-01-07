package org.poj;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

/**
 * Calendar(http://poj.org/problem?id=2080)
 * <p/>
 * <p/>
 * 日历题,使用Calandar
 */
public class Main2080 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd EEEE", Locale.US);
        int n;
        while ((n = cin.nextInt()) != -1) {
            Calendar cal = Calendar.getInstance();
            cal.set(2000, Calendar.JANUARY, 1);
            cal.add(Calendar.DATE, n);
            System.out.println(sdf.format(cal.getTime()));
        }
    }
}