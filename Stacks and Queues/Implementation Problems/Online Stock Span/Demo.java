class StockSpanner {

    int[] stack;
    int[] span;
    int top;
    public StockSpanner() {
        stack = new int[1_0000];
        span = new int[1_0000];
        top = -1;
    }
    
    public int next(int price) {
        int cnt = 1;
        while(top != -1 && stack[top] <= price) {
            cnt += span[top];
            --top;
        }
        stack[++top] = price;
        span[top] = cnt;
        return span[top];
    }
}

// class StockSpanner {

//     int[] stack;
//     int[] span;
//     int top;
//     int currDay;

//     public StockSpanner() {
//         stack = new int[1_0000];
//         span = new int[1_0000];
//         top = -1;
//         currDay = -1;
//     }
    
//     // currDay is 0-based indexing
//     public int next(int price) {
        
//         while(top != -1 && stack[top] <= price)
//             --top;

//         stack[++top] = price;
//         span[top] = ++currDay;
//         return top == 0 ? currDay + 1 : currDay - span[top-1];
//     }
// }

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */