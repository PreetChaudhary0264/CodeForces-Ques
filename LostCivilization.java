import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class LostCivilization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            Deque<Integer> stack = new ArrayDeque<>();
            int c = 0;
            for(int i = 0; i < n; i++){
                while(!stack.isEmpty() && (stack.peek() >= arr[i] || stack.peek() != arr[i]-1)){
                    stack.pop();
                }
                if(stack.isEmpty() || stack.peek() != arr[i] - 1)c++;
                stack.push(arr[i]);
            }
            System.out.println(c);
        }
    }
}
