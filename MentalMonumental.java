import java.util.*;

public class MentalMonumental {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            System.out.println(solve(n, a));
        }
    }

    public static int solve(int n, int[] a) {
        Arrays.sort(a);
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : a) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        List<Integer> free = new ArrayList<>();
        TreeMap<Integer, Boolean> uniqueAvailable = new TreeMap<>();

        for (int x : a) {
            if (!uniqueAvailable.containsKey(x)) {
                uniqueAvailable.put(x, true);
                for (int i = 0; i < freq.get(x) - 1; i++) {
                    free.add(x);
                }
            }
        }
        Collections.sort(free);

        int currentX = 0;
        int freePtr = 0;

        while (true) {
            if (uniqueAvailable.getOrDefault(currentX, false)) {
                uniqueAvailable.put(currentX, false);
                currentX++;
            } else {
                int target = 2 * currentX + 1;
                boolean satisfied = false;
                while (freePtr < free.size() && free.get(freePtr) < target) {
                    freePtr++;
                }

                if (freePtr < free.size()) {
                    freePtr++;
                    currentX++;
                    satisfied = true;
                } else {
                    Integer lastKey = uniqueAvailable.lastKey();
                    while (lastKey != null) {
                        if (!uniqueAvailable.get(lastKey)) {
                            uniqueAvailable.remove(lastKey); // Remove already used unique values
                            lastKey = uniqueAvailable.isEmpty() ? null : uniqueAvailable.lastKey();
                        } else if (lastKey < target) {
                            lastKey = null;
                            break;
                        } else {
                            break;
                        }
                    }

                    if (lastKey != null) {
                        uniqueAvailable.put(lastKey, false);
                        currentX++;
                        satisfied = true;
                    }
                }

                if (!satisfied) break;
            }
        }
        int mexwf = currentX;
        return mexwf;
    }
}