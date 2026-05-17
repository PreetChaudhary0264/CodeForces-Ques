import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DeepDownBelow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();

        while(test-- > 0){

            int n = sc.nextInt();

            List<int[]> maxOfEachCave = new ArrayList<>();

            int overAllMax = 0;

            for(int i = 0; i < n; i++){

                int v = sc.nextInt();

                int need = 0;

                for(int j = 0; j < v; j++){

                    int val = sc.nextInt();

                    need = Math.max(need, val - j + 1);
                }

                overAllMax = Math.max(overAllMax, need);

                maxOfEachCave.add(new int[]{need, v});
            }

            Collections.sort(maxOfEachCave, (a,b)-> a[0] - b[0]);

            int l = 0;
            int r = overAllMax + 100000;
            int ans = 0;

            while(l <= r){

                int mid = l + (r - l) / 2;

                if(possible(mid, maxOfEachCave)){
                    ans = mid;
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }

            System.out.println(ans);
        }
    }

    private static boolean possible(int mid, List<int[]> list){

        for(int i = 0; i < list.size(); i++){

            if(mid < list.get(i)[0]) return false;

            mid += list.get(i)[1];
        }

        return true;
    }
}
