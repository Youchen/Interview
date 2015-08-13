public class Solution {
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
    public String largestNumber(int[] num) {
        //2015-05-29 18:53:58 - 2015-05-29 19:11:37 (18 min)
        if(num == null || num.length == 0)
            return "";
        
        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int i : num)
            al.add(i);
        
        Collections.sort(al, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                String s1 = "" + o1 + o2;
                String s2 = "" + o2 + o1;
                
                return s2.compareTo(s1);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for(Integer i : al)
            sb.append(String.valueOf(i));
        
        if(sb.toString().charAt(0) == '0')
            return "0";
        
        return sb.toString();
    }
}

