package org.poj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 递归题目
 */
class F implements Comparable<F> {
    public D par;
    public String name;

    public F(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(F o) {
        return this.name.compareTo(o.name);
    }
}

class D extends F {
    public List<F> files = new ArrayList<F>();
    public List<F> dirs = new ArrayList<F>();

    public D(String name) {
        super(name);
    }

    public void addF(F f) {
        files.add(f);
        f.par = this;
    }

    public D addD(D f) {
        dirs.add(f);
        f.par = this;
        return f;
    }
}

public class Main1057 {
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        int seq = 1;
        while (true) {
            String s;
            if ((s = cin.next()).equals("#"))
                break;

            D root = new D("ROOT");
            D curr = root;
            if (s.startsWith("d")) {
                curr = root.addD(new D(s));
            } else if (s.startsWith("f")) {
                root.addF(new F(s));
            }

            while (!(s = cin.next()).equals("*")) {
                if (s.startsWith("d")) {
                    curr = curr.addD(new D(s));
                } else if (s.startsWith("f")) {
                    curr.addF(new F(s));
                } else if (s.startsWith("]")) {
                    curr = curr.par;
                }
            }

            System.out.println("DATA SET " + (seq++) + ":");
            dir(root, 0);
            System.out.println();
        }
    }

    private static void dir(D r, int depth) {
        for (int i = 0; i < depth; i++)
            System.out.print("|     ");
        System.out.println(r.name);
        for (F f : r.dirs) {
            if (f instanceof D)
                dir((D) f, depth + 1);
        }

        Collections.sort(r.files);
        for (F f : r.files) {
            for (int i = 0; i < depth; i++)
                System.out.print("|     ");
            System.out.println(f.name);
        }
    }
}