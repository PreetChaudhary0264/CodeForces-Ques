import java.util.*;

public class EFOSL {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            String s = scanner.next();
            Map<Character, Integer> freq = new HashMap<>();
            int count = 0;
            int[] distinct = new int[n];
            for (int i = 0; i < n; i++) {
                char currentChar = s.charAt(i);
                freq.put(currentChar, freq.getOrDefault(currentChar, 0) + 1);
                if (freq.get(currentChar) == 1) {
                    count++;
                }
                distinct[i] = count;
            }

            long ans = 0;
            for (int i = 0; i < n; i++) {
                ans += distinct[i];
            }

            System.out.println(ans);
        }
    }
}
