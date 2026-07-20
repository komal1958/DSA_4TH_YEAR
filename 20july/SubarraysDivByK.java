import java.util.HashMap;

public class SubarraysDivByK {

    static long subarraysDivByK(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        long ans = 0;
        long sum = 0;

        for (int x : arr) {
            sum += x;

            int remainder = (int) ((sum % k + k) % k);

            ans += map.getOrDefault(remainder, 0);

            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = {4, 5, 0, -2, -3, 1};
        int k = 5;

        long result = subarraysDivByK(arr, k);

        System.out.println("Number of subarrays divisible by " + k + " = " + result);
    }
}
