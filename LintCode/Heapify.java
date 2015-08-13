/**
 * main idea is:
 *      suppose the heap have h levels, we iterate from the most right
 *          node in level h - 1, til the top.
 * 
 *      for each node that we iterating, we do a "sift-down" operation.
 *      The sift-down simply doing like this.
 *          in the father - child - child triangle, find min value index.
 *          then swap this min node with the father node.
 *      then mark this min node as father. repeat the above operation.
 *          until the min is the father.
 */
public class Solution {
    public void heapify(int[] A) {
        //2015-06-18 17:18:43 - 2015-06-18 18:06:44 (48 min)
        if(A == null || A.length == 0)
            return;
            
        for(int i = A.length / 2; i >= 0; i--)
            siftDown(A, i);
    }
    private void siftDown(int[] A, int k){
        while(k < A.length){
            int smallest = k;
            
            //in the father - child - child triangle, find min value index.
            if(k * 2 + 1 < A.length && A[k * 2 + 1] < A[smallest])//smallest CAN be changed to k
                smallest = k * 2 + 1;
            if(k * 2 + 2 < A.length && A[k * 2 + 2] < A[smallest])//smallest CANNOT be changed to k
                smallest = k * 2 + 2;
            
            if(smallest == k)
                break;
                
            swap(A, smallest, k);
            
            k = smallest;
        }
    }
    private void swap(int[] A, int a, int b){
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}
