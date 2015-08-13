/**
 * Very nice problem.
 * 
 * Note:
 *      MinHeap: the top nodes is the MIN of all.
 *      MaxHeap: the top nodes is the MAX of all.
 * 
 *      Be careful for balancing the two heap.
 *          the structure is like:
 *          
 *          ......... _ , _ .........  ( " _ " is the top element)
 *            MaxHeap       MinHeap
 *      
 *      Size: Max.size() == Min.size() || Max.size() == Min.size() + 1
 *          
 *          __          __
 *          ||      __  ||
 *          ||      ||  ||
 *      ---------------------
 *        MaxHeap   MinHeap
 *  
 *      if MaxHeap has more
 *          => if Max.size > Min.size + 1
 *      if MinHeap has more
 *          => if Min.size > Max.size.
 * 
 * Reference:
 *      http://blog.csdn.net/xudli/article/details/46389077
 */
public class Solution {
    public int[] medianII(int[] nums) {
        //2015-06-18 16:37:07 - 2015-06-18 17:09:20 ( 32 min )
        if(nums == null || nums.length == 0)
            return null;
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = 
                new PriorityQueue<Integer>(10, new Comparator<Integer>(){
                    // @override
                    public int compare(Integer a, Integer b){
                        return b - a;
                    }
                });
        maxHeap.add(nums[0]);
        
        int len = nums.length;
        int[] res = new int[len];
        res[0] = maxHeap.peek();
        
        for(int i = 1; i < nums.length; i++){
            int x = maxHeap.peek();
            
            //add data into heap.
            if(nums[i] <= x)
                maxHeap.add(nums[i]);
            else
                minHeap.add(nums[i]);
               
            //adjust these two heap, so that 
            //      maxHeap.size() == minHeap.size()    OR
            //      maxHeap.size() == minHeap.size() + 1
            
            //maxHeap has more nodes
            if(minHeap.size() + 1 < maxHeap.size())
                minHeap.add(maxHeap.poll());
                
            //minHeap has more nodes
            else if (minHeap.size() > maxHeap.size() )
                maxHeap.add(minHeap.poll());
            
            res[i] = maxHeap.peek();
        }
        return res;
    }
}
