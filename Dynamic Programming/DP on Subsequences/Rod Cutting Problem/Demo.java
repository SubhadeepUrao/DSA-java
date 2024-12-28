class Solution {
    int cutRod(int[] price, int i, int length) {
        if (i == 0 || length == 0) return 0;

        if (length >= i)
            return Math.max(cutRod(price, i, length - i) + price[i-1], cutRod(price, i - 1, length));
        return cutRod(price, i - 1, length);
    }

    public int cutRod(int[] price) {
        int N = price.length;
        return cutRod(price, N, N);
    }
}

// class Solution {
//     int cutRod(int[] price, int i, int length) {
//         if (i < 0 || length == 0) return 0;
        
//         if (length >= i + 1)
//             return Math.max(cutRod(price, i, length - i - 1) + price[i], cutRod(price, i - 1, length));
//         return cutRod(price, i - 1, length);
//     }

//     public int cutRod(int[] price) {
//         int N = price.length;
//         return cutRod(price, N - 1, N);
//     }
// }