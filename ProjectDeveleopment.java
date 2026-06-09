import java.util.Scanner;

public class ProjectDeveleopment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();

        while (test-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            int time1 = (n + x + y - 1) / (x + y);
            int time2;
            if (n <= z * x) {
                time2 = (n + x - 1) / x;
            } else {
                int remL = n - z * x;

                int cs = x + 10 * y;
                int at = (remL + cs - 1) / cs;
                time2 = z + at;
            }
            System.out.println(Math.min(time1, time2));
        }
    }
}
