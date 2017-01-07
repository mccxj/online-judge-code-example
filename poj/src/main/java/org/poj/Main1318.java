package org.poj;

import java.util.*;

/**
 * Word Amalgamation(http://poj.org/problem?id=1318)
 * <p/>
 * <p/>
 * 字符串操作题目,使用Map即可
 */
public class Main1318 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);

        Map<String, ArrayList<String>> dict = new HashMap<String, ArrayList<String>>();
        String s, ts;
        while (!"XXXXXX".equals(s = cin.nextLine())) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            ts = String.valueOf(cs);

            ArrayList<String> vals = dict.get(ts);
            if (vals == null) {
                vals = new ArrayList<String>();
                dict.put(ts, vals);
            }
            vals.add(s);
        }

        while (!"XXXXXX".equals(s = cin.nextLine())) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            ts = String.valueOf(cs);

            ArrayList<String> vals = dict.get(ts);
            if (vals == null) {
                System.out.println("NOT A VALID WORD");
            } else {
                Collections.sort(vals);
                for (String val : vals)
                    System.out.println(val);
            }
            System.out.println("******");
        }
    }
}