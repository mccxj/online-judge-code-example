package org.poj.test;

import java.io.*;
import java.util.Scanner;

/**
 * 为了方便测试,可以生成一个简单的代码模板
 *
 * @author mc02cxj@gmail.com
 */
public class TemplateMaker {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        int pid = cin.nextInt();

        System.out.println("generate file with problem id: " + pid);
        copyFile(new File("./poj/src/java/org/poj/Main1000.java"), new File("./poj/src/java/org/poj/Main" + pid + ".java"));
        copyFile(new File("./poj/src/resources/org/poj/1000.1.in"), new File("./poj/src/resources/org/poj/" + pid + ".1.in"));
        copyFile(new File("./poj/src/resources/org/poj/1000.1.out"), new File("./poj/src/resources/org/poj/" + pid + ".1.out"));
    }

    private static void copyFile(File sourceFile, File targetFile) throws IOException {
        BufferedInputStream inBuff = null;
        BufferedOutputStream outBuff = null;
        try {
            inBuff = new BufferedInputStream(new FileInputStream(sourceFile));
            outBuff = new BufferedOutputStream(new FileOutputStream(targetFile));

            // 缓冲数组
            byte[] b = new byte[1024];
            int len;
            while ((len = inBuff.read(b)) != -1) {
                outBuff.write(b, 0, len);
            }
            outBuff.flush();
        } finally {
            closeQuietly(inBuff);
            closeQuietly(outBuff);
        }
    }

    private static void closeQuietly(Closeable res) {
        try {
            if (res != null)
                res.close();
        } catch (IOException e) {
            // ignore
        }
    }
}
