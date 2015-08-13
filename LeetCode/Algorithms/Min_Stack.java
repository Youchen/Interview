/**
 * Round 2
 * Using one Stack.
 */
class MinStack {
    //2015-06-15 23:23:14 - 2015-06-15 23:31:51 (8 min)
    /**
     * | min | num | min | num | ...
     */
    Stack<Integer> stack;
    
    public MinStack(){
        stack = new Stack<Integer>();
    }
    
    public void push(int x) {
        if(stack.size() == 0){
            stack.push(x);
        }else{
            int min = this.getMin();
            
            if(x < min){
                stack.push(x);
            }else{
                stack.push(min);
            }
        }
        stack.push(x);
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        int num = stack.pop();
        int min = stack.pop();
        stack.push(min);
        stack.push(num);
        
        return min;
    }
}











/**
 * Round 2
 * Remember the idea is
 *      by using two corresponding stack.
 */
class MinStack {
    //2015-06-15 23:06:33 pause 2015-06-15 23:07:39
    //2015-06-15 23:10:40 - 2015-06-15 23:18:17 (9 min)
    
    Stack<Integer> minStack;
    Stack<Integer> stack;
    boolean firstTime = true;
    
    public void push(int x) {
        if(firstTime){
            firstTime = false;
            minStack = new Stack<Integer>();
            stack = new Stack<Integer>();
        }
        stack.push(x);
        
        if(minStack.size() != 0){
            if(stack.peek() < minStack.peek() )
                minStack.push(stack.peek());
            else
                minStack.push(minStack.peek());
        }
        else
            minStack.push(x);
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        int top = stack.peek();
        minStack.peek();
        return top;
    }

    public int getMin() {
        return minStack.peek();
    }
}








import java.util.*;
/**
 * O(n)
 * O(n)
 * 292 ms
 * 
 * Stack
 * 
 * Note(important!):
 *      if Stack is Stack<Integer>, when you peek()
 *      the return object is "Integer" typed.
 *      you CANNOT DO s.peek() == minS.peek() since you're 
 *      comparing two object NOT VALUE!!
 * 
 *      Correct way is to make comparison like
 *      s.peek().intValue() == minS.peek().intValue().
 */
class MinStack {
    Stack<Integer> s = new Stack<Integer>();
    Stack<Integer> minS = new Stack<Integer>();
    
    public void push(int x) {
        if(! minS.isEmpty() && x <= minS.peek())
            minS.push(x);
        s.push(x);
        if(minS.isEmpty())
            minS.push(x);
    }

    public void pop() {
        if(s.peek().intValue() == minS.peek().intValue())
            minS.pop();
        s.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return minS.peek();
    }
}
