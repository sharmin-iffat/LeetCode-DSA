class MyStack {
    Queue<Integer> q = new LinkedList<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        q.add(x);
        
    }
    
    public int pop() {
        int size = q.size();
        for(int i=0; i<size-1; i++){
            q.add(q.poll());
        }
        int front = q.poll();
        return front;
    }
    
    public int top() {
        int size = q.size();
        for(int i=0; i<size-1; i++){
            q.add(q.poll());
        }
        int front = q.peek();
        q.add(q.poll());
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