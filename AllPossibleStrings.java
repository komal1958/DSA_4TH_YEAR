import java.util.*;
import java.io.*;

public class Main {

    static class Solution {

        public List<String> AllPossibleStrings(String s) {
            List<String> ans = new ArrayList<>();
            generate(s, 0, new StringBuilder(), ans);
            Collections.sort(ans);
            return ans;
        }

        private void generate(String s, int idx, StringBuilder curr, List<String> ans) {
            if (idx == s.length()) {
                if (curr.length() > 0) {
                    ans.add(curr.toString());
                }
                return;
            }

            curr.append(s.charAt(idx));
            generate(s, idx + 1, curr, ans);

            curr.deleteCharAt(curr.length() - 1);
            generate(s, idx + 1, curr, ans);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(br);

        st.nextToken();
        String s = st.sval;

        Solution obj = new Solution();
        List<String> ans = obj.AllPossibleStrings(s);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i));
            if (i != ans.size() - 1) {
                System.out.print(" ");
            }
        }
    }
}
