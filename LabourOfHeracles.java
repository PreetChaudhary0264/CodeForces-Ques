import java.util.*;

public class LabourOfHeracles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int[] weight = new int[n];
            long w = 0;
            for(int i = 0; i < n; i++){
                int val = sc.nextInt();
                w += val;
                weight[i] = val;
            }
            int[] degrees = new int[n];

            for(int i=0;i<n-1;i++){
                int u=sc.nextInt();
                int v=sc.nextInt();
                degrees[u-1]++;
                degrees[v-1]++;
            }
            List<Long> list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                if(degrees[i] >= 2){
                    for(int j = 0; j < degrees[i]-1; j++){
                        list.add((long) weight[i]);
                    }
                }
            }
            Collections.sort(list, Collections.reverseOrder());

            for(int i = 0; i < n-1; i++){
                System.out.print(w + " ");
                if(i < list.size())
                    w += list.get(i);
            }
            System.out.println();
        }
    }
}
