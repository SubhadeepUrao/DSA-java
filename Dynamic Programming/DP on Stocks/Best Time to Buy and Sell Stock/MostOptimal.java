class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int elem : prices) {
            if(elem < minPrice)
                minPrice = elem;
            maxProfit = Math.max(maxProfit, elem - minPrice);
        }
        return maxProfit;
    }
}