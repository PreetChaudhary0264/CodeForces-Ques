import java.util.*;

public class ScoringSubsequences {
    public static void main(String[] args) {
        // Optimize input and output operations
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt(); // Read the number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt(); // Read the length of the sequence for the current test case

            int[] a = new int[n];
            // Read the sequence of integers
            for (int i = 0; i < n; i++) { // O(n)
                a[i] = scanner.nextInt();
            }

            List<Integer> res = new ArrayList<>(); // To store the result for each k

            // Calculate the cost for each k
            for (int i = 0; i < n; i++) { // O(nlogn)
                int l = 1, r = i + 1;
                // Perform binary search to find the maximum length of subsequence
                while (l <= r) {
                    int m = (l + r) / 2;
                    // Check if the subsequence of length m can have the maximum score
                    if (a[i - m + 1] >= m) {
                        l = m + 1; // Try to find a longer subsequence
                    } else {
                        r = m - 1; // Reduce the length of the subsequence
                    }
                }
                res.add(r); // Store the result for the current k
            }

            // Output the results for the current test case
            for (int i : res) { // O(n)
                System.out.print(i + " ");
            }
            System.out.println();
        }

        scanner.close();
    }

    // Time Complexity (TC): O(nlogn)
    // Space Complexity (SC): O(n)
}
