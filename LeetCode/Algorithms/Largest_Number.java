/**
 * Learn how to overwrite the compare method and 
 *      the how to use the Comparator Interface inside the Collections.sort() method.
 */
public class Solution {
    public String largestNumber(int[] nums) {
        //2015-05-29 19:28:30 - 2015-05-29 19:32:08 (4 min)
        if(nums == null || nums.length == 0)
            return "";
            
        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int i : nums)
            al.add(i);
        
        Collections.sort(al, new Comparator<Integer>(){//large -> small
           public int compare(Integer o1, Integer o2){
               String s1 = "" + o1 + o2;
               String s2 = "" + o2 + o1;
               
               return s2.compareTo(s1);
           } 
        });
        
        StringBuilder sb = new StringBuilder();
        for(Integer i : al)
            sb.append(i);
        
        if(sb.toString().charAt(0) == '0')
            return "0";
        
        return sb.toString();
    }
}