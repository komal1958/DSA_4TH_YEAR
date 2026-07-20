import java.util.HashSet;

public class LongestConsecutive {

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> s = new HashSet<>();

        for (int x : nums) {
            s.add(x);
        }

        int ans = 0;

        for (int x : s) {
            if (!s.contains(x - 1)) {
                int y = x;

                while (s.contains(y)) {
                    y++;
                }

                ans = Math.max(ans, y - x);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};

        int result = longestConsecutive(nums);

        System.out.println("Length of Longest Consecutive Sequence: " + result);
    }
}
