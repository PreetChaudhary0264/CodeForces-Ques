import java.util.*;

public class DecString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        StringBuilder out = new StringBuilder();

        while (T-- > 0) {
            String s = sc.next();
            long pos = sc.nextLong();

            int n = s.length();

            int del = 0;
            long cur = n;

            while (pos > cur) {
                pos -= cur;
                cur--;
                del++;
            }

            Deque<Character> st = new ArrayDeque<>();

            for (char c : s.toCharArray()) {
                while (!st.isEmpty() && del > 0 && st.peekLast() > c) {
                    st.pollLast();
                    del--;
                }
                st.addLast(c);
            }

            while (del > 0) {
                st.pollLast();
                del--;
            }

            int idx = (int) pos - 1;

            for (char c : st) {
                if (idx == 0) {
                    out.append(c);
                    break;
                }
                idx--;
            }
        }

        System.out.print(out);
    }
}
