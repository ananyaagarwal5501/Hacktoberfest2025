class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int l = 0, r = 0;
        int checkCount = 0;
        int count = 0;

        while (r < nums.length) {
            if (nums[r] % 2 != 0) {
                checkCount++;
            }

            // shrink window if too many odds
            while (checkCount > k) {
                if (nums[l] % 2 != 0) checkCount--;
                l++;
            }

            // if checkCount == k, count all possible subarrays ending at r
            if (checkCount == k) {
                int temp = l;
                while (checkCount == k) {
                    count++;
                    if (nums[temp] % 2 != 0) checkCount--;
                    temp++;
                }
                // restore checkCount for next iteration
                while (temp > l) {
                    temp--;
                    if (nums[temp] % 2 != 0) checkCount++;
                }
            }

            r++;
        }

        return count;
    }
}
