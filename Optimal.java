import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Optimal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            if (3 * a <= b) {
                sb.append(n * a).append("\n");
            } else {
                long fullGroups = n / 3;
                long rem = n % 3;

                long baseCost = fullGroups * b;
                long remainderCost = Math.min(rem * a, b);

                sb.append(baseCost + remainderCost).append("\n");
            }
        }
        System.out.print(sb);
    }
}
