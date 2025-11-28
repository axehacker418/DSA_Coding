public class twentiseven_NOV {

    public static int subarrayPrint(int[] nums, int k) {

        if (k > nums.length) {
            return 0;
        }

        if (nums.length == k) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            return sum;
        }

        int maxSum = Integer.MIN_VALUE;
        int n = nums.length;

        // We try all subarrays of length divisible by k
        for (int start = 0; start < n; start++) {
            for (int len = k; len <= n - start; len += k) {

                int sum = 0;
                for (int i = start; i < start + len; i++) {
                    sum += nums[i];
                }

                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 3 };
        int k = 3;
        System.out.println(subarrayPrint(nums, k));
    }
}




/*


class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        // For each remainder group (0..k-1), track smallest prefix sum seen so far
        long[] minPrefix = new long[k];
        boolean[] seen = new boolean[k];

        long ans = Long.MIN_VALUE;

        for (int i = 0; i <= n; i++) {
            int r = i % k;

            if (seen[r]) {
                // compute subarray sum = prefix[i] - minPrefix[r]
                ans = Math.max(ans, prefix[i] - minPrefix[r]);
            } else {
                seen[r] = true;
            }

            // update smallest prefix for this remainder
            minPrefix[r] = Math.min(minPrefix[r], prefix[i]);
        }

        return ans;
    }
}


*/