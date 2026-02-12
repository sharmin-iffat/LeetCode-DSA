class MyStack {
    Queue<Integer> q = new LinkedList<>();
    Queue<Integer> helper = new LinkedList<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        q.add(x);
        
    }
    
    public int pop() {
        while(q.size() > 1){
            helper.add(q.poll());
        }
        int front = q.poll();
        while(helper.size() > 0){
            q.add(helper.poll());
        }
        return front;
    }
    
    public int top() {
        while(q.size() > 1){
            helper.add(q.poll());
        }
        int front = q.peek();
        helper.add(q.poll());
        while(helper.size() > 0){
            q.add(helper.poll());
        }
        return front;
        
    }
    
    public boolean empty() {
        if(q.size() > 0) return false;
        else return true;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */