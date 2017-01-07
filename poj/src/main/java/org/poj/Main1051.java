package org.poj;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * P,MTHBGWB(http://poj.org/problem?id=1051)
 * <p/>
 * <p/>
 * 字符操作题目,使用哈希来存储
 */
public class Main1051 {
    private static final Map<String, String> a = new HashMap<String, String>();
    private static final Map<String, String> b = new HashMap<String, String>();

    static {
        a.put("A", ".-");
        a.put("B", "-...");
        a.put("C", "-.-.");
        a.put("D", "-..");
        a.put("E", ".");
        a.put("F", "..-.");
        a.put("G", "--.");
        a.put("H", "....");
        a.put("I", "..");
        a.put("J", ".---");
        a.put("K", "-.-");
        a.put("L", ".-..");
        a.put("M", "--");
        a.put("N", "-.");
        a.put("O", "---");
        a.put("P", ".--.");
        a.put("Q", "--.-");
        a.put("R", ".-.");
        a.put("S", "...");
        a.put("T", "-");
        a.put("U", "..-");
        a.put("V", "...-");
        a.put("W", ".--");
        a.put("X", "-..-");
        a.put("Y", "-.--");
        a.put("Z", "--..");
        a.put("_", "..--");
        a.put(".", "---.");
        a.put(",", ".-.-");
        a.put("?", "----");
        for (Entry<String, String> e : a.entrySet()) {
            b.put(e.getValue(), e.getKey());
        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = Integer.parseInt(cin.nextLine());
        for (int i = 1; i <= n; i++) {
            String s = cin.nextLine();
            StringBuilder sb = new StringBuilder();
            int[] len = new int[s.length()];
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                String k = a.get(String.valueOf(c));
                sb.append(k);
                len[j] = k.length();
            }

            StringBuilder sb2 = new StringBuilder();
            int start = 0;
            for (int j = s.length() - 1; j >= 0; j--) {
                String k = sb.substring(start, start + len[j]);
                sb2.append(b.get(k));
                start += len[j];
            }
            System.out.println(i + ": " + sb2.toString());
        }
    }
}