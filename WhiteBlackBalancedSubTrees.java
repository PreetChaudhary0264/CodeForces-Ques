import java.util.*;

public class WhiteBlackBalancedSubTrees {
    // Global variable to store the number of balanced subtrees
    static int ans = 0;

    // Depth First Search function to calculate the balance of subtrees
    static int dfs(int node, List<List<Integer>> adj, String s) {
        // If the node is a leaf node, return 1 if it's white, -1 if it's black
        if (adj.get(node).size() == 0) {
            return s.charAt(node - 1) == 'W' ? 1 : -1;
        }

        // Initialize count to track the balance of the current subtree
        int count = 0;

        // Recursively calculate the balance for each child
        for (int child : adj.get(node)) {
            count += dfs(child, adj, s);
        }

        // Adjust count based on the color of the current node
        count += (s.charAt(node - 1) == 'W' ? 1 : -1);

        // If the subtree is balanced, increment the answer
        if (count == 0) {
            ans++;
        }

        // Return the balance count of the current subtree
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases
        while (t-- > 0) {
            ans = 0; // Reset the answer for each test case
            int n = scanner.nextInt(); // Number of vertices in the tree

            // Adjacency list to represent the tree
            List<List<Integer>> adj = new ArrayList<>(n + 1);
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }

            // Read the parent-child relationships
            for (int i = 0; i < n - 1; i++) { // O(n)
                int temp = scanner.nextInt();
                adj.get(temp).add(i + 2);
            }

            // Read the color string
            String s = scanner.next();

            // Perform DFS starting from the root node
            dfs(1, adj, s); // O(n)

            // Output the number of balanced subtrees
            System.out.println(ans);
        }
    }

    // Time Complexity (TC): O(n)
    // Space Complexity (SC): O(n)
}

