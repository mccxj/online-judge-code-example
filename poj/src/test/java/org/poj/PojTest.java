package org.poj;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;

/**
 * 为了方便测试,写的测试桩,运行时需要带上待测试类名作为参数
 * <p/>
 * <p/>
 * 文件命名规范:<br/>
 * 待测试类名:以Main+题号标识,例如org.poj.Main1000<br/>
 * 输入测试数据:以题号+序号+in标识,跟待测试类名在同一个包下,例如org/poj/1000.1.in<br/>
 * 输出测试数据:以题号+序号+out标识,跟待测试类名在同一个包下,例如org/poj/1000.1.out<br/>
 * 输入数据和输出数据根据序号来匹配,多个测试数据的话,从1开始累加，中间不能间断
 *
 * @author mc02cxj@gmail.com
 */
@RunWith(Parameterized.class)
public class PojTest {
    private static final String MAIN_PREX = "Main";
    private static final String OJ_PACKAGE = "org.poj";
    private static final String OJ_DEF = "org.poj.Main";
    private final String problemId;

    public PojTest(String problemId) {
        this.problemId = problemId;
    }

    @Parameterized.Parameters(name = "{index}: {0}")
    public static Collection<String[]> data() throws Exception {
        List<String[]> testData = new ArrayList<String[]>();
        String packageDirName = OJ_PACKAGE.replace('.', '/');
        Enumeration<URL> dirs = Main1000.class.getClassLoader().getResources(packageDirName);
        while (dirs.hasMoreElements()) {
            URL url = dirs.nextElement();
            String protocol = url.getProtocol();
            if ("file".equals(protocol)) {
                String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                getClassByFile(OJ_PACKAGE, filePath, testData);
            }
        }
        return testData;
    }

    @Test
    public void testProblem() throws Exception {
        String cmd = OJ_DEF + problemId;
        Class<?> main = Class.forName(cmd);
        ClassLoader cl = main.getClassLoader();

        int nidx = main.getSimpleName().indexOf(MAIN_PREX);
        String seq = main.getSimpleName().substring(nidx + MAIN_PREX.length());
        String pk = main.getPackage().getName().replaceAll("\\.", "/") + "/" + seq + ".";

        PrintStream defps = System.out;
        InputStream res = null;
        InputStream is = null;
        ByteArrayOutputStream os = null;

        int idx = 1;
        do {
            String in = pk + idx + ".in";
            String out = pk + idx + ".out";

            try {
                res = cl.getResourceAsStream(out);
                is = cl.getResourceAsStream(in);
                if (res == null || is == null) {
                    System.out.println("Not any more tests");
                    break;
                }

                System.out.println("test " + idx + " starting: ");
                System.out.println("test in is " + in);
                System.out.println("test out is " + out);

                // Standard Input/Output Redirect
                System.setIn(is);
                os = new ByteArrayOutputStream();
                System.setOut(new PrintStream(os, true));

                // Invoke main method
                Method m = main.getMethod("main", new Class[]{String[].class});
                m.invoke(main, new Object[]{null});

                // Reset Standard Output
                System.setOut(defps);
                String aos = readAsString(res);

                System.out.println("Excepted is: ");
                System.out.println(aos);
                System.out.println("Actual is: ");
                System.out.println(os.toString());

                boolean ok = os.toString().equals(aos);
                if (!ok) {
                    System.err.println("Validate Result is Failed");
                    break;
                } else {
                    System.out.println("Validate Result is OK");
                }
                System.out.println();
                // Next Test
                idx++;
            } finally {
                closeQuietly(os);
                closeQuietly(is);
                closeQuietly(res);
            }
        } while (true);
    }

    /**
     * 以文件的形式来获取包下的所有Class
     *
     * @param pkgName 包名
     * @param pkgPath 包路径
     */
    protected static void getClassByFile(String pkgName, String pkgPath, final List<String[]> testData) throws ClassNotFoundException {
        File dir = new File(pkgPath);
        if (!dir.exists() || !dir.isDirectory()) {
            return;
        }

        File[] dirfiles = dir.listFiles(new FileFilter() {
            public boolean accept(File file) {
                String fileName = file.getName();
                return fileName.endsWith(".class") && fileName.startsWith(MAIN_PREX) && !fileName.contains("$");
            }
        });

        for (File file : dirfiles) {
            if (!file.isDirectory()) {
                String className = file.getName().substring(0, file.getName().length() - 6);
                testData.add(new String[]{className.substring(MAIN_PREX.length())});
            }
        }
    }

    private static String readAsString(InputStream res) throws IOException {
        StringBuilder sb = new StringBuilder();
        byte[] bs = new byte[128];
        int len;
        while ((len = res.read(bs)) != -1) {
            sb.append(new String(bs, 0, len));
        }
        return sb.toString();
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
