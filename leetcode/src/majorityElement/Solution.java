package majorityElement;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p/>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p/>
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 */
public class Solution {
    public int majorityElement(int[] num) {
        int major = 0;
        int count = 0;
        for (int elem : num) {
            major = count == 0 ? elem : major;
            count += elem == major ? 1 : -1;
        }
        return major;
    }
}
