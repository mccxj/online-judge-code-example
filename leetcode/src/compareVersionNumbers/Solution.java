package compareVersionNumbers;

/**
 * Compare two version numbers version1 and version1.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * <p/>
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 * <p/>
 * Here is an example of version numbers ordering:
 * <p/>
 * 0.1 < 1.1 < 1.2 < 13.37
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 */
public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int i = 0;
        while (i < v1.length && i < v2.length) {
            int iv1 = Integer.parseInt(v1[i]);
            int iv2 = Integer.parseInt(v2[i]);
            if (iv1 < iv2) {
                return -1;
            } else if (iv1 > iv2) {
                return 1;
            }
            i++;
        }

        while (i < v1.length) {
            if (Integer.parseInt(v1[i]) != 0) {
                return 1;
            }
            i++;
        }
        while (i < v2.length) {
            if (Integer.parseInt(v2[i]) != 0) {
                return -1;
            }
            i++;
        }
        return 0;
    }
}
