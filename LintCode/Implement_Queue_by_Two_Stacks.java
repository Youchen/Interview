public class Solution {
    //2015-06-16 08:40:21 - 2015-06-16 08:45:22 (5 min)
    
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Solution() {
       stack1 = new Stack<Integer>();
       stack2 = new Stack<Integer>();
    }
    
    public void push(int element) {
        stack1.push(element);
    }

    public int pop() {
        if(!stack2.isEmpty() )
            return stack2.pop();
        else{
            //move all elements in stack1 to stack2
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int top() {
        if(!stack2.isEmpty())
            return stack2.peek();
        else{
            //move all elements in stack1 to stack2
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    
    
}

