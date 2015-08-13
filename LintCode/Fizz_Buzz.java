class Solution {
    /**
     * param n: As description.
     * return: A list of strings.
     */
    public ArrayList<String> fizzBuzz(int n) {//Apr 3 - 21:50 - 21:54 (4 min)
        ArrayList<String> res = new ArrayList<String>();
        if(n < 0)
            return res;
        
        int iterator = 1;
        while(iterator <= n){
            if(iterator % 15 == 0)
                res.add("fizz buzz");
            else if(iterator % 3 == 0)
                res.add("fizz");
            else if(iterator % 5 == 0)
                res.add("buzz");
            else
                res.add(String.valueOf(iterator));
                
            iterator++;
        }
        return res;
    }
}


