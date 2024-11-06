import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.empty() || val <= minStack.peek())
            minStack.push(val);
        // else
        //     minStack.push(minStack.peek());
    }
    
    public void pop() {
        if(stack.peek().equals(minStack.peek()))
            minStack.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

// class MinStack {
//     Stack < Long > st = new Stack < Long > ();
//     Long mini;

//     /** initialize your data structure here. */
//     public MinStack() {
//         mini = Long.MAX_VALUE;
//     }

//     public void push(int value) {
//         Long val = Long.valueOf(value);
//         if (st.isEmpty()) {
//             mini = val;
//             st.push(val);
//         } else {
//             if (val < mini) {
//                 st.push(2 * val - mini);
//                 mini = val;
//             } else {
//                 st.push(val);
//             }
//         }
//     }

//     public void pop() {
//         if (st.isEmpty()) return;

//         Long val = st.pop();
//         if (val < mini) {
//             mini = 2 * mini - val;
//         }
//     }

//     public int top() {
//         Long val = st.peek();
//         if (val < mini) {
//             return mini.intValue();
//         }
//         return val.intValue();
//     }

//     public int getMin() {
//         return mini.intValue();
//     }
// }