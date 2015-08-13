/**
 * Round 2
 * Note:
 *      isBadVersion == false indicating it's a good version.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        //2015-05-11 12:05:30 -4 2015-05-11 12:24:42 (15 min)
        if(n <= 0)
            return -1;
        
        int left = 1, right = n;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if( VersionControl.isBadVersion(mid) )
                right = mid;
            else
                left = mid;
        }
        if( VersionControl.isBadVersion(left) )
            return left;
        return right;
    }
}














/**
 * public class VersionControl {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use VersionControl.isBadVersion(k) to judge wether 
 * the kth code version is bad or not.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {//Apr 3 - 21:27 - 21:42 (15 min)
        // write your code here
        //the version is like
        //      false, false, false, ... true, true, true, true ...
        if(n <= 0)
            return -1;
        
        int first = 1, last = n, mid;
        while(first + 1 < last){
            mid = first + (last - first) / 2;
            if(VersionControl.isBadVersion(mid) == false )
                first = mid;
            else if(VersionControl.isBadVersion(mid) == true )
                last = mid;
        }
        if(VersionControl.isBadVersion(first) == true)
            return first;
        else if(VersionControl.isBadVersion(last) == true)
            return last;
        else
            return 0;
    }
}


