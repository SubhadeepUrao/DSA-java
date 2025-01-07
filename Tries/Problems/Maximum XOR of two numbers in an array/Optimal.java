import java.util.HashSet;
import java.util.Set;

public class Optimal {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        for (int num : nums)
            max = Math.max(max, num);

        // find MSB that is 1
        int bit = 31; // since num is +ve, we can skip the MSB i.e. 32th bit(1-indexed)
        while (--bit >= 0) {
            if ((max >> bit & 1) == 1)
                break;
        }

        int mask, masks = 0, ans = 0;
        for (int i = bit; i >= 0; --i) {
            mask = 1 << i;
            masks |= mask;
            // if ans | mask is assumed to be ans then find is it possible to find XOR pairs
            if (check(nums, masks, ans | mask)) {
                ans |= mask;
            }
        }
        return ans;
    }

    boolean check(int[] nums, int masks, int ans) {
        Set<Integer> st = new HashSet<>();
        for (int num : nums) {
            num &= masks;
            if (st.contains(num ^ ans))
                return true;
            st.add(num);
        }
        return false;
    }
}