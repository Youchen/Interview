public class Solution {
    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
    public String binaryRepresentation(String n) {
        //2015-05-28 02:55:43 - 2015-05-28 03:51:47 (56 min)
        if(n == null || n.length() == 0)
            return "ERROR";
        
        int wholeNum = Integer.parseInt(n.substring(0, n.indexOf(".")));
        double floating = Double.parseDouble(n.substring(n.indexOf("."), n.length()));
        
        //convert wholeNum part
        /**
         *  20 / 2 = 10 - 0
            10 / 2 = 5 - 0
            5 / 2 = 2 - 1
            2 / 2 = 1 - 0
            1 / 2 = 0 - 1
            
            10100
        */
        StringBuilder sb = new StringBuilder();
        while(wholeNum / 2 != 0){
            
            int remain = wholeNum % 2;
            sb.insert(0, Integer.toString(remain));
            
            wholeNum /= 2;
        }
        sb.insert(0, Integer.toString(wholeNum % 2));
        
        // int wholeNumLen = sb.length();
        // int floatingLen = 32 - wholeNumLen - 1;//"." occupy 1 char.
        
        if(floating != 0){
            sb.append(".");
            /**
             *  0.75 * 2 = 1.5 - 1
                (1.5 - 1) * 2 = 1 - 1
                (1 - 1) * 2 = 0
                
                .11000
                */
            int whole = 0;
            while(floating != 0 ){
                floating = (floating - whole) * 2;
                if(floating == 0)
                    break;
                else{
                    whole = (int) floating % 2;
                    sb.append(Integer.toString(whole));
                    if(sb.length() >= 50)
                        return "ERROR";
                }
             }
        }
        return sb.toString(); 
    }
}

