import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DefinitelyLarger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int[] p = new int[n];
            for(int i = 0; i < n; i++){
                p[i] = sc.nextInt();
            }
            int[] d = new int[n];
            for(int i = 0; i < n; i++){
                d[i] = sc.nextInt();
            }
            //pehle validity check kro
            boolean valid = true;
            List<int[]> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                int c = 0;
                for(int j = i+1; j < n; j++){
                    if(p[j] > p[i])c++;
                }
                if(c < d[i]){
                    valid = false;
                    break;
                }
                list.add(new int[]{p[i],i});
            }
            if(!valid){
                System.out.println(-1);
                continue;
            }
            Collections.sort(list, (a,b) -> b[0] - a[0]);
            List<Integer> ord = new ArrayList<>();
            for(int[] pair : list){
                int i = pair[1];
                int jgreaterthani = 0;
                for(int val : ord){
                    if(val > i)jgreaterthani++;
                }
                if(d[i] > jgreaterthani){
                    valid = false;
                    break;
                }
                int needBefore = jgreaterthani - d[i];
                int count = 0;
                boolean inserted = false;
                for(int k = 0; k < ord.size(); k++){
                    if(ord.get(k) > i){
                        if(count == needBefore){
                            ord.add(k,i);
                            inserted = true;
                            break;
                        }
                        count++;
                    }
                }
                if(!inserted){
                    ord.add(i);
                }
            }
            if(!valid){
                System.out.println(-1);
                continue;
            }
            int[] q = new int[n];
            for(int i = 0; i < n; i++){
                q[ord.get(i)] = i + 1;
            }

            for(int i = 0; i < n; i++){
                System.out.print(q[i] + " ");
            }
            System.out.println();
        }
    }
}
