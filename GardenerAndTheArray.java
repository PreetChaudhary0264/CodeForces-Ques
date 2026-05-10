import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class GardenerAndTheArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            HashMap<Integer,Integer> mpp = new HashMap<>();
            List<List<Integer>> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                int a = sc.nextInt();
                List<Integer> temp = new ArrayList<>();
                for(int j = 0; j < a; j++){
                    int val = sc.nextInt();
                    mpp.put(val,mpp.getOrDefault(val,0)+1);
                    temp.add(val);
                }
                list.add(temp);
            }
            String ans= "NO";
            for(List<Integer> l  :list){
                boolean repeated = true;
                for(int pos : l){
                    if(mpp.get(pos) == 1){
                        repeated = false;
                        break;
                    }
                }
                if(repeated){
                    ans = "YES";
                    break;
                }
            }
            System.out.println(ans);
        }
    }
}
