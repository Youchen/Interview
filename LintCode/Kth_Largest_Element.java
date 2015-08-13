/**
 * Just copied the solution and understood it. so
 * DO THIS AGAIN
 */
class Solution {
    //param k : description of k
    //param numbers : array of numbers
    //return: description of return
    public int kthLargestElement(int k, ArrayList<Integer> numbers) {
        if(k < 1 || numbers == null)
            return 0;
        
        return getKth(numbers.size() - k + 1, numbers, 0, numbers.size() - 1);
    }
    public int getKth(int k, ArrayList<Integer> numbers, int start, int end){
        int pivot = numbers.get(end);
        
        int left = start;
        int right = end;
        
        while(true){
            while(numbers.get(left) < pivot && left < right) left++;
            while(numbers.get(right) >= pivot && right > left) right--;
            
            if(left == right) break;
            
            swap(numbers, left, right);
        }
        
        //left is the index of the number which is the first number larger than the pivot.
        swap(numbers, left, end);
        
        if(k == left + 1)
            return pivot;
        if(k < left + 1)
            return getKth(k, numbers, start, left - 1);
        return getKth(k, numbers, left + 1, end);
            
        
    }
    private void swap(ArrayList<Integer> numbers, int left, int right){
        int tmp = numbers.get(left);
        numbers.set(left, numbers.get(right));
        numbers.set(right, tmp);
    }
};