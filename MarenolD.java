import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarenolD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            String a  =sc.next();
            String b = sc.next();
            List<Integer> ae = new ArrayList<>();
            List<Integer> ao = new ArrayList<>();
            List<Integer> be = new ArrayList<>();
            List<Integer> bo = new ArrayList<>();
            for(int i = 0; i < n; i++){
                if(a.charAt(i) == '1'){
                    if(i % 2 == 0)ae.add(i);
                    else ao.add(i);
                }
                if(b.charAt(i) == '1'){
                    if(i % 2 == 0)be.add(i);
                    else bo.add(i);
                }
            }
            if(ae.size() != be.size() || ao.size() != bo.size()){
                System.out.println(-1);
                continue;
            }
            //sort isliye need nhi hai kyuki left to right jare hai already sorted milega :)

            long ans = 0;
            for(int i = 0; i < ae.size(); i++){
                ans += (Math.abs(ae.get(i) - be.get(i))) / 2;
            }
            for(int i = 0; i < ao.size(); i++){
                ans += (Math.abs(ao.get(i) - bo.get(i))) / 2;
            }
            System.out.println(ans);
        }
    }
}
