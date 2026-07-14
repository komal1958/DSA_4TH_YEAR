import java.util.*;

class Solution {

    static List<Integer> specialXor(int N, int Q, int[] a, int[][] query) {

        List<Integer> x = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        x.add(a[0]);

        for (int i = 1; i < N; i++) {
            x.add(a[i] ^ x.get(i - 1));
        }

        int sep_xor = 0;

        for (int i = 0; i < Q; i++) {
            int l = query[i][0] - 1;
            int r = query[i][1] - 1;

            if (l == 0)
                sep_xor = x.get(r);
            else
                sep_xor = x.get(r) ^ x.get(l - 1);

            ans.add(x.get(N - 1) ^ sep_xor);
        }

        return ans;
    }

    public static void main(String[] args) {

        int N = 10, Q = 3;
        int[] a = {4, 7, 8, 5, 9, 6, 1, 0, 20, 10};
        int[][] query = {{3, 8}, {1, 6}, {2, 3}};

        List<Integer> result = specialXor(N, Q, a, query);

        System.out.print("Results: ");
        for (int res : result) {
            System.out.print(res + " ");
        }
        System.out.println();
    }
}
