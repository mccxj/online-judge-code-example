package restoreIpAddresses;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p/>
 * For example:
 * Given "25525511135",
 * <p/>
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ips = new ArrayList<String>();
        if (s == null || s.length() < 4 || s.length() > 12) {
            return ips;
        }

        int len = s.length();
        for (int i = 1; i <= 3 && i <= len - 3; i++) {
            String ip1 = s.substring(0, i);
            if (!isValidIp(ip1)) {
                break;
            }
            for (int j = i + 1; j <= len - 2; j++) {
                String ip2 = s.substring(i, j);
                if (!isValidIp(ip2)) {
                    break;
                }
                for (int k = j + 1; k <= len - 1; k++) {
                    String ip3 = s.substring(j, k);
                    if (!isValidIp(ip3)) {
                        break;
                    }
                    String ip4 = s.substring(k);
                    if (isValidIp(ip4)) {
                        ips.add(ip1 + "." + ip2 + "." + ip3 + "." + ip4);
                    }
                }
            }
        }
        return ips;
    }

    public static boolean isValidIp(String ip) {
        return (ip.length() <= 1 || ip.charAt(0) != '0') && Integer.valueOf(ip) <= 255;
    }

    @Test
    public void test() {
        List<String> ips = restoreIpAddresses("25525511135");
        assertEquals(2, ips.size());
        assertTrue(ips.contains("255.255.11.135"));
        assertTrue(ips.contains("255.255.111.35"));

        List<String> ips2 = restoreIpAddresses("0000");
        assertTrue(ips2.contains("0.0.0.0"));

        List<String> ips3 = restoreIpAddresses("101023");
        assertEquals(5, ips3.size());
    }
}
