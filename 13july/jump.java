import java.util.*;

public class Main {

    public static int jump(int[] nums) {

        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            // Find the farthest index we can reach
            farthest = Math.max(farthest, i + nums[i]);

            // If we reach the end of the current jump range
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter the array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int ans = jump(nums);

        System.out.println("Minimum jumps required = " + ans);

        sc.close();
    }
}
