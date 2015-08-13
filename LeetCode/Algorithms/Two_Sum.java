/**
 * From jiuzhang.com
 * 2015-06-25 00:56:00
 */
public class Solution {
    public int[] twoSum_hashmap(int[] numbers, int target) {
        if(numbers == null || numbers.length < 2) {
            return null;
        }
        HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
        for(int i=0; i<numbers.length; i++){
            hs.put(numbers[i], i+1);
        }       
        
        int[] a = new int[2];
        
        for(int i=0; i<numbers.length ; i++){
            if ( hs.containsKey( target - numbers[i] )){
                int index1 = i+1;
                int index2 = hs.get(target - numbers[i]);
                if (index1 == index2){
                    continue;
                }
                a[0] = index1;
                a[1] = index2;
                return a;
            }
        }
        return a;
    }

    
    public int[] twoSum_pointer(int[] numbers, int target) {
            if(numbers == null || numbers.length < 2) {
                return null;
            }
            Arrays.sort(numbers);
            int left = 0;
            int right = numbers.length - 1;
            int[] rst = new int[2];
            
            while( left < right){
                int sum = numbers[left] +  numbers[right];
                if( sum == target){
                    rst[0] = left + 1;
                    rst[1] = right + 1;
                    break;
                }else if( sum < target){
                    left++;
                }else{
                    right--;
                }
            }
            return rst;
        }

}







/**
 * O(n)
 * 368 ms
 * 
 * Hashtable
 *      constructor, put(), containsKey(), get();
 * Array
 *      return new int[]{2, 3};
 */
import java.util.*;
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        // int[] sol = new int[2];
        
        // /**
        //  * trial #1
        //  */
        // for(int i = 0; i <= numbers.length - 2; i++){
            
        //     for(int j = i + 1; j <= numbers.length - 1; j++){
        //         if (numbers[i] + numbers[j] == target){
        //             sol[0] = i + 1;
        //             sol[1] = j + 1;
        //             return sol;
        //         }//if
        //         //if( j == numbers.length - 1) break;   
        //     }//j
        //     //if(numbers[i] > target) break;
        // }//i
        
        /**
         * trial #2
         */
        // int backIndex = numbers.length - 1;
        
        // for(int i = 0; i <= numbers.length - 2; i++){
        //     if (numbers[i] + numbers[backIndex] == target){
        //             sol[0] = i + 1;
        //             sol[1] = backIndex + 1;
        //             return sol;
        //     }//if
        //     while( numbers[backIndex] > target )//|| numbers[backIndex] > target - numbers[i])
        //         backIndex--;
        // }

        /**
         * trial #3
         */
        //hashtable <key, index> i.e. <2, 1>
        Hashtable<Integer, Integer> sol = new Hashtable<Integer, Integer>();
        for(int i = 0; i <= numbers.length - 1; i++){
            sol.put(numbers[i], i + 1);
        }
        for(int i = 0; i <= numbers.length - 1; i++){
            if(sol.containsKey(target - numbers[i]) && i+1 < sol.get(target - numbers[i])){        
                return new int[]{i+1, sol.get(target - numbers[i])};
            }
        }
        return null;

        /**
         * solution from 
         *      http://blog.csdn.net/fightforyourdream/article/details/13013147
         */
        // 放值和数组下标  
        // Hashtable<Integer, Integer> ht = new Hashtable<Integer, Integer>();  
        // int[] ret = new int[2];  
          
        // for(int i=0; i<numbers.length; i++){  
        //     // 对每一个数边放边查找  
        //     if(ht.get(target-numbers[i]) != null){  
        //         ret[0] = ht.get(target-numbers[i]) + 1;  
        //         ret[1] = i+1;  
        //     }else{  
        //         ht.put(numbers[i], i);  
        //     }  
        // }  
          
        // return ret;  
        
    }
}