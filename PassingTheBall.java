import java.util.Scanner;

public class PassingTheBall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            // visited[i] will be true if the (i+1)-th student received the ball
            boolean[] visited = new boolean[n];

            // Step 1: The first student receives the ball
            int currentPos = 0;
            visited[currentPos] = true;

            // Step 2: Pass the ball exactly n times
            for (int i = 0; i < n; i++) {
                if (s.charAt(currentPos) == 'R') {
                    currentPos++;
                } else {
                    currentPos--;
                }

                // Record the student who just received the ball
                visited[currentPos] = true;
            }

            // Step 3: Count how many unique students were visited
            int count = 0;
            for (boolean v : visited) {
                if (v) count++;
            }

            System.out.println(count);
        }
        //heheheheheheheheheheheheheheehheheheheeheheh
    }
}
