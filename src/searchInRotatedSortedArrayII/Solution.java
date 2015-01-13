package searchInRotatedSortedArrayII;

/**
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * <p/>
 * Would this affect the run-time complexity? How and why?
 * <p/>
 * Write a function to determine if a given target is in the array.
 */
public class Solution {
    public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return false;
        }
        int l = 0, r = A.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (A[m] == target) {
                return true; // return m in Search in Rotated Array I
            }
            if (A[l] < A[m]) { // left half is sorted
                if (A[l] <= target && target < A[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } else if (A[l] > A[m]) { // right half is sorted
                if (A[m] < target && target <= A[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            } else {
                l++;
            }
        }
        return false;
    }
}