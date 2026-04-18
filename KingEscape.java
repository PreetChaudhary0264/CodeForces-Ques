import java.util.*;

public class KingEscape {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int ax = sc.nextInt(), ay = sc.nextInt();
        int bx = sc.nextInt(), by = sc.nextInt();
        int cx = sc.nextInt(), cy = sc.nextInt();

        boolean kingLeft = bx < ax;
        boolean kingBelow = by < ay;
        boolean targetLeft = cx < ax;
        boolean targetBelow = cy < ay;

        if (kingLeft == targetLeft && kingBelow == targetBelow) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
