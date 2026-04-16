import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseWishes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            for(int i = 0; i < k; i++){
                sc.nextInt();
            }
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            int ops = 0;
            List<Integer> list = new ArrayList<>();
            while(true){
                if(ops > 1000){
                    ops = -1;
                    break;
                }
                int max = -1;int maxIdx = -1;
                for(int i = 0; i < n; i++){
                    if(arr[i] == k+1)continue;
                    if(arr[i] > max){
                        max = arr[i];
                        maxIdx = i;
                    }
                }
                if(max == -1){
                    break;
                }
                arr[maxIdx]++;
                list.add(maxIdx+1);
                ops++;
            }
            System.out.println(ops);
            for(int i = 0; i < list.size(); i++){
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }
}
