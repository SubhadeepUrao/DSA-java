class Solution {
    // maximum edges a graph of n vertices can have n(n-1)/2 edges
    // no. of graphs that can be formed with n vertices: [let e = n(n-1)/2]
    //     n vertices with 0 edge : eC0 graphs (in nCr form)
    //     n vertices with 1 edge : eC1 graphs
    //     n vertices with 2 edge : eC2 graphs
    //     .
    //     .
    //     n vertices with e edge : eCe graphs
    // ------------------------------------
    //               total graphs : 2^e graphs
    // ------------------------------------


    static long count(int n) {
        return 1L << n * (n - 1) / 2;
    }
    
    // static long count(int n) {
    //     return (long) Math.pow(2, n * (n - 1) / 2);
    // }
}
