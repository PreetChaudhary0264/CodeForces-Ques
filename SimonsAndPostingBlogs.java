import java.util.*;
import java.io.*;

public class SimonsAndPostingBlogs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            List<Integer>[] list = new ArrayList[n];
            for(int i = 0; i < n; i++){
                int len = sc.nextInt();
                list[i] = new ArrayList<>();
                for(int j = 0; j < len; j++) {
                    list[i].add(sc.nextInt());
                }
                // Ab hum reverse NAHI kar rahe hain.
            }

            List<Integer> ans = new ArrayList<>();
            Set<Integer> seenElements = new HashSet<>();
            boolean[] usedBlogs = new boolean[n];

            for(int step = 0; step < n; step++){
                int bestIdx = -1;

                for (int i = 0; i < n; i++) {
                    if (usedBlogs[i]) continue;
                    // Comparison piche se hoga
                    if (bestIdx == -1 || isSmallerBackward(list[i], list[bestIdx], seenElements)) {
                        bestIdx = i;
                    }
                }

                usedBlogs[bestIdx] = true;

                // Q mein elements blog ke aakhir se shuru hokar insert hote hain
                List<Integer> currentBlog = list[bestIdx];
                for (int j = currentBlog.size() - 1; j >= 0; j--) {
                    int val = currentBlog.get(j);
                    if (!seenElements.contains(val)) {
                        ans.add(val);
                        seenElements.add(val);
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < ans.size(); i++){
                sb.append(ans.get(i)).append(i == ans.size() - 1 ? "" : " ");
            }
            System.out.println(sb.toString());
        }
    }

    // Yeh function decide karega ki kaunsa blog Q ke front mein chote elements layega
    static boolean isSmallerBackward(List<Integer> a, List<Integer> b, Set<Integer> seen) {
        int i = a.size() - 1;
        int j = b.size() - 1;

        // In-blog duplicates ko track karne ke liye temporary sets
        Set<Integer> seenInA = new HashSet<>();
        Set<Integer> seenInB = new HashSet<>();

        while (i >= 0 || j >= 0) {
            // Skip elements jo GLOBAL 'seen' mein hain YA is blog mein pehle hi (piche se) aa chuke hain
            while (i >= 0 && (seen.contains(a.get(i)) || seenInA.contains(a.get(i)))) {
                i--;
            }
            if (i >= 0) seenInA.add(a.get(i));

            while (j >= 0 && (seen.contains(b.get(j)) || seenInB.contains(b.get(j)))) {
                j--;
            }
            if (j >= 0) seenInB.add(b.get(j));

            if (i < 0 && j < 0) return false;
            if (i < 0) return true;
            if (j < 0) return false;

            if (!a.get(i).equals(b.get(j))) {
                return a.get(i) < b.get(j);
            }

            i--;
            j--;
        }
        return false;
    }
}
