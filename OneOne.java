import java.util.Scanner;

public class OneOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while(test-- > 0){
            int n = sc.nextInt();
            String s = sc.next();
            char[] arr = s.toCharArray();
            int ones = 0;
            for(int i = 0; i < n; i++){
                if(arr[i] == '1')ones++;
            }
            int zeros = arr[0] == '0' ? 1 : 0;
            for(int i = 1; i < n-1; i++){
                if(arr[i] == '0' && arr[i-1] == '1' && arr[i+1] == '1'){
                    arr[i] = '1';
                    ones++;
                }
                if(arr[i] == '0')zeros++;
            }
            if(arr[n-1] == '0')zeros++;
            int i = 0;
            while(i < n){
                if(arr[i] == '1'){
                    int start = i;
                    while(i < n && arr[i] == '1'){
                        i++;
                    }
                    int length = i - start;
                    if(length % 2 == 1){
                        zeros  = zeros + (length / 2);
                    }else{
                        zeros = zeros + (length / 2) - 1;
                    }
                }else{
                    i++;
                }
            }
            System.out.print(n - zeros + " " + ones);
            System.out.println();
        }
    }
}
