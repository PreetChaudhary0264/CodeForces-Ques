import java.util.Arrays;
import java.util.Scanner;

public class COABS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test= sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            boolean[] matches = new boolean[n];
            for(int i = 0; i < n; i++){
                char ch = s.charAt(i);
                if(ch == ')'){
                    for(int j = i-1; j >= 0; j--){
                        if(s.charAt(j) == '(' && !matches[j]){
                            matches[j] = true;
                            matches[i] = true;
                            break;
                        }
                    }
                }
            }
            int li = 0;
            int sum = 0;
            int msum = 0;
            for(int i = 0; i < n; i++){
                char ch = s.charAt(i);
                sum += (ch == '(') ? 1 : -1;

                if(sum < msum){
                    msum = sum;
                    li = i+1;
                }else if(sum == msum)li = i+1;
            }
//            System.out.println(li);
//            System.out.println(msum);
            char[] ans = new char[n];
            Arrays.fill(ans,'0');
            for(int i = 0; i < n; i++){
                if(k == 0)break;
                char ch = s.charAt(i);

                if(matches[i]){
                    if((ch == '(' && i < li) || (ch == ')' && i >= li)){
                        k--;
                        ans[i] = '1';
                    }
                }
            }
            System.out.println(new String(ans));
        }
    }
}
