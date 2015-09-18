/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        //2015-09-13 18:22:34 - 2015-09-13 18:24:47 (2 min)
            
        int left = 1, right = n;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            
            if(isBadVersion(mid))
                right = mid;
            else
                left = mid;
        }
        return isBadVersion(left) ? left : right;
    }
}