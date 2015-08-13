public class Solution {
    
    Stack<Integer> stack;

    public Solution() {
        stack = new Stack<Integer>();
    }

    public void push(int x) {
        if(stack.size() == 0){
            stack.push(x);
        }else{
            int min = this.min();
            
            if(x < min){
                stack.push(x);
            }else{
                stack.push(min);
            }
        }
        stack.push(x);

    }

    public int pop() {
        int pop = stack.pop();
        stack.pop();
        return pop;
    }

    public int min() {
        int num = stack.pop();
        int min = stack.pop();
        stack.push(min);
        stack.push(num);
        
        return min;
    }
}