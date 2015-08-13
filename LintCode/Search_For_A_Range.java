public class Solution {
    public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        //2015-05-25 21:45:12 - 2015-05-25 21:59:41 (14 min)
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(-1);
        res.add(-1);
        if(A == null || A.size() == 0)
            return res;
        
        int left = 0, right = A.size() - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(A.get(mid) < target)
                left = mid;
            else
                right = mid;
        }
        if(A.get(left) != target && A.get(right) != target){
            return res;
        }
        
        //find the element
        if(A.get(left) == target)
            res.set(0, left);
        else
            res.set(0, right);
            
        left = 0;
        right = A.size() - 1;
        
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(A.get(mid) <= target)
                left = mid;
            else
                right = mid;
        }
        if(A.get(right) == target)
            res.set(1, right);
        else
            res.set(1, left);
            
        return res;
    }
}


