class MyStack {
    //2015-06-28 00:56:06 -1 min - 2015-06-28 01:11:56 (14 min)
    /**
     * You must use only standard operations of a queue
     *      -- which means only push to back, 
     *      peek/pop from front, size, and is empty 
     *      operations are valid.
     */
    Queue<Integer> q = new LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        q.add(x);
        //since only peek/pop from FRONT is valid
        //  we need to reverse the queue.
        //ex: 1 2 3 -> 3 2 1
        for(int i = 0; i < q.size() - 1; i++)
            q.add(q.poll());
    }

    // Removes the element on top of the stack.
    public void pop() {
        q.poll();
    }

    // Get the top element.
    public int top() {
        return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.size() == 0;
    }
}