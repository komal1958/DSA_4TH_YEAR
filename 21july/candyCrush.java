import java.util.*;

public class candyCrush {

    public static String Reduced_String(int k, String s) {

        if (k == 1) return "";

        Stack<int[]> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek()[0] == ch) {
                stack.peek()[1]++;

                if (stack.peek()[1] == k) {
                    stack.pop();
                }
            } else {
                stack.push(new int[]{ch, 1});
            }
        }

        StringBuilder ans = new StringBuilder();

        for (int[] p : stack) {
            for (int i = 0; i < p[1]; i++) {
                ans.append((char) p[0]);
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int k = sc.nextInt();
            String s = sc.next();

            System.out.println(Reduced_String(k, s));
        }

        sc.close();
    }
}
