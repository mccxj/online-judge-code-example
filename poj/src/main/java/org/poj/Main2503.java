package org.poj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Babelfish(http://poj.org/problem?id=2503)
 * <p/>
 * <p/>
 * 字典查找,如果使用排序+两分查找,不过内存有点大(main2),如果使用Trie树,效果会好些(main)
 */
class TrieNode {
    String val;
    TrieNode[] child;
}

class Trie {
    TrieNode head = new TrieNode();

    public void insert(String val, String key) {
        TrieNode tmp = head;
        int len = key.length();
        for (int i = 0; i < len; i++) {
            if (tmp.child == null)
                tmp.child = new TrieNode[26];
            int t = key.charAt(i) - 'a';
            if (tmp.child[t] == null)
                tmp.child[t] = new TrieNode();
            tmp = tmp.child[t];
        }
        tmp.val = val;
    }

    public String find(String key) {
        TrieNode tmp = head;
        int len = key.length();
        for (int i = 0; i < len; i++) {
            if (tmp.child == null)
                return null;
            tmp = tmp.child[key.charAt(i) - 'a'];
            if (tmp == null)
                return null;
        }
        return tmp.val;
    }
}

public class Main2503 {
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str;
        StringTokenizer token;
        Trie trie = new Trie();
        while (!(str = reader.readLine()).isEmpty()) {
            token = new StringTokenizer(str);
            trie.insert(token.nextToken(), token.nextToken());
        }

        while ((str = reader.readLine()) != null) {
            String val = trie.find(str);
            if (val == null)
                System.out.println("eh");
            else
                System.out.println(val);
        }
    }

    public static void main2(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str;
        StringTokenizer token;
        int curr = 0;
        String[][] dict = new String[100000][2];
        while (!(str = reader.readLine()).isEmpty()) {
            token = new StringTokenizer(str);
            dict[curr++] = new String[]{token.nextToken(), token.nextToken()};
        }

        Comparator<String[]> comparator = new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[1].compareTo(o2[1]);
            }
        };
        Arrays.sort(dict, 0, curr, comparator);

        int idx;
        while ((str = reader.readLine()) != null) {
            idx = Arrays.binarySearch(dict, 0, curr, new String[]{null, str}, comparator);
            if (idx < 0)
                System.out.println("eh");
            else
                System.out.println(dict[idx][0]);
        }
    }
}