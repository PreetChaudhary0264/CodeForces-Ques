import java.util.*;
import java.io.*;

public class PartyMonster {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            if (n % 2 != 0) {
                System.out.println("NO");
                continue;
            }
            int minP = 0;
            int maxP = 0;
            int current = 0;

            for (char c : s.toCharArray()) {
                if (c == '(') current++;
                else current--;
                minP = Math.min(minP, current);
                maxP = Math.max(maxP, current);
            }

            if (current != 0) {
                System.out.println("NO");
                continue;
            }
            if (minP >= 0) {
                System.out.println("YES");
                continue;
            }

            int firstNeg = -1, lastNeg = -1;
            int firstPosAfterMax = -1;
            current = 0;
            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '(') current++;
                else current--;

                if (current < 0) {
                    if (firstNeg == -1) firstNeg = i;
                    lastNeg = i;
                }
            }

            // Check if removing the range [firstNeg, lastNeg] works
            if (check(s, firstNeg, lastNeg)) {
                System.out.println("YES");
            } else {
                // Check from the other side (maximums)
                int firstMax = -1, lastMax = -1;
                current = 0;
                int maxVal = 0;
                // Find the range that contributes to the "peak" that causes issues
                for(int i = 0; i < n; i++){
                    if(s.charAt(i) == '(') current++;
                    else current--;
                    if(current > maxVal) maxVal = current;
                }

                // If simple negation doesn't work, we check the contiguous property
                // But for this specific problem, the logic simplifies to:
                // Is the violation contiguous?
                boolean possible = true;
                current = 0;
                int start = 0;
                while(start < n && current >= 0) {
                    if(s.charAt(start) == '(') current++;
                    else current--;
                    start++;
                }
                // start-1 is where it first becomes negative
                int end = n - 1;
                int suffix = 0;
                while(end >= 0 && suffix >= 0) {
                    if(s.charAt(end) == ')') suffix++;
                    else suffix--;
                    end--;
                }
                // end+1 is where suffix first becomes negative

                // If we remove everything between the first failure and last failure
                if (check(s, start - 1, end + 1)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    // Helper to verify if the string is valid after removing s[l...r] 
    // and re-placing those brackets optimally.
    static boolean check(String s, int l, int r) {
        if (l == -1 || r == -1 || l > r) return false;
        int open = 0, close = 0;
        StringBuilder remaining = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i >= l && i <= r) {
                if (s.charAt(i) == '(') open++;
                else close++;
            } else {
                remaining.append(s.charAt(i));
            }
        }

        // To be valid, we'd put all '(' from the removed part at the start 
        // and all ')' at the end (or as needed).
        String test = "(".repeat(open) + remaining.toString() + ")".repeat(close);
        int cur = 0;
        for (char c : test.toCharArray()) {
            if (c == '(') cur++;
            else cur--;
            if (cur < 0) return false;
        }
        return cur == 0;
    }
}