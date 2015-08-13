public class Solution {
    public int countPrimes(int n) {
    //2015-06-15 18:41:43 - 2015-06-15 18:49:35 (8 min)
        if(n <= 1)
            return 0;
            
        boolean[] isPrime = new boolean[n];
        for(int i = 0; i < n; i++)
            isPrime[i] = true;
            
        int count = 0;
        
        for(int i = 2; i < n; i++){
            if( isPrime[i] ){
                count++;
                for(int j = 2; i * j < n; j++)
                    isPrime[i * j] = false;
            }
        }
        return count;
    }
}






//************* TLE ***********************
public class Solution {
    public int countPrimes(int n) {
        //2015-06-15 16:01:23 - 2015-06-15 16:23:00 (TLE)
        if(n <= 1)
            return 0;
        
        //n >= 2
        ArrayList<Integer> prime = new ArrayList<Integer>();
        
        for(int j = 2; j <= n; j++){//check if j is prime.
            int sqrtJ = (int) Math.sqrt(j);
            boolean flag = true;
            
            for(int i = 2; i <= sqrtJ; i++){
                
                for(int pri : prime){
                    if(pri <= i && j % pri == 0){
                        flag = false;
                        break;
                    }
                }
                if(!flag)
                    break;
            }
        
            prime.add(j);
        }
        
        return prime.size();
    }
}