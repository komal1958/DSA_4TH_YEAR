import java.util.*;

class Solution {

    public int shortestSubArrayOfSumK(int[] nums, int k) {

        long[] prefix = new long[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Deque<Integer> dq = new LinkedList<>();

        int ans = nums.length + 1;

        for (int i = 0; i < prefix.length; i++) {

            while (!dq.isEmpty() && prefix[i] - prefix[dq.peekFirst()] >= k) {
                ans = Math.min(ans, i - dq.pollFirst());
            }

            while (!dq.isEmpty() && prefix[i] <= prefix[dq.peekLast()]) {
                dq.pollLast();
            }

            dq.offerLast(i);
        }

        return ans == nums.length + 1 ? -1 : ans;
    }

    public static void main(String[] args) {

        Solution obj = new Solution();

        int[] nums = {2, -1, 2};
        int k = 3;

        System.out.println(obj.shortestSubArrayOfSumK(nums, k));
    }
}
