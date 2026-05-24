import java.util.*;

public class TA {
    private static List<Integer> findMax3(List<Integer> arr) {
        List<Map.Entry<Integer, Integer>> tmp = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            tmp.add(new AbstractMap.SimpleEntry<>(arr.get(i), i));
        }
        tmp.sort((a, b) -> b.getKey().compareTo(a.getKey())); // O(N log N)
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ans.add(tmp.get(i).getValue());
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int n = scanner.nextInt();
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();
            List<Integer> c = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                a.add(scanner.nextInt());
            }

            for (int i = 0; i < n; i++) {
                b.add(scanner.nextInt());
            }
            for (int i = 0; i < n; i++) {
                c.add(scanner.nextInt());
            }
            List<Integer> maxa = findMax3(a);
            List<Integer> maxb = findMax3(b);
            List<Integer> maxc = findMax3(c);

            int ans = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        int x = maxa.get(i), y = maxb.get(j), z = maxc.get(k);
                        if (x == y || y == z || z == x) continue;
                        ans = Math.max(ans, a.get(x) + b.get(y) + c.get(z));
                    }
                }
            }

            System.out.println(ans);
        }
    }
}

