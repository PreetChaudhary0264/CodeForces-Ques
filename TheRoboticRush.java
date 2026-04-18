import java.util.*;

public class TheRoboticRush {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            long[] robots = new long[n];
            for(int i = 0; i < n; i++){
                robots[i] = sc.nextLong();
            }
            long[] spikes = new long[m];
            TreeSet<Long> set = new TreeSet<>();
            for(int i = 0; i < m; i++){
                spikes[i] = sc.nextLong();
                set.add(spikes[i]);
            }
            String s = sc.next();
            HashMap<Long, List<Integer>> left = new HashMap<>();
            HashMap<Long,List<Integer>> right = new HashMap<>();
            for(int i = 0; i < n; i++){
                long robot = robots[i];
                Long lesser = set.lower(robot);
                Long more = set.higher(robot);

                if(lesser != null){
                    long diff = robot - lesser;
                    left.computeIfAbsent(diff, c -> new ArrayList<>()).add(i);
                }
                if(more != null){
                    long diff = more - robot;
                    right.computeIfAbsent(diff, c -> new ArrayList<>()).add(i);
                }
            }
            int ans = n;
            long shift = 0L;
            HashSet<Integer> deleted = new HashSet<>();
            for(char ch : s.toCharArray()){
                if(ch == 'R'){
                    shift++;
                    if(right.containsKey(shift)){
                        int count = 0;
                        //dekhne me ye n^2 lg skta hai but nhi hai bcoz hr robot prr max 2 baar hi ja rhe hai, dhyan se socho to pta chl jayga ki n^2 nhi hai(diff kitne nikl skte hai? agar diff n hai to hr list me 1 hi element hoga)
                        for(int i : right.get(shift)){
                            if(!deleted.contains(i))count++;
                            deleted.add(i);
                        }
                        ans -= count;
                        right.remove(shift);
                    }
                }else{
                    shift--;
                    if(shift < 0){
                        long need = -shift;
                        if(left.containsKey(need)){
                            int count = 0;
                            for(int i : left.get(need)){
                                if(!deleted.contains(i))count++;
                                deleted.add(i);
                            }
                            ans -= count;
                            left.remove(need);
                        }
                    }
                }
                System.out.print(ans + " ");
            }
            System.out.println();
        }
    }
}

//ye bhi approach ho skti hai
//Step 1: Shift History BanaoPehle poori string (instructions) ko scan karo aur track karo ki kaunsa displacement (shift) kis time (instruction index) par pehli baar hit hua.Example: Agar RRLLR hai, toh:Shift +1 hua step 1 par.Shift +2 hua step 2 par.Shift 0 hua step 4 par.Step 2: Har Robot ka Safe Zone nikaloHar robot $a_i$ ke liye:Uske sabse paas wala Left Spike $L$ dhundo. Use marne ke liye distL = L - a_i (negative value) tak jana hoga.Uske sabse paas wala Right Spike $R$ dhundo. Use marne ke liye distR = R - a_i (positive value) tak jana hoga.Step 3: Pehla Collision dhundoAb check karo:distL pehli baar kab hit hua? (Maano step 5 par)distR pehli baar kab hit hua? (Maano step 3 par)In dono mein se jo chota index hoga (yahan Step 3), wahi us robot ka actual Death Step hai.Step 4: Final CountingEk array banao deathsAt[step]. Agar ek robot step 3 par mar raha hai, toh deathsAt[3]++. Last mein total robots $n$ mein se subtract karte chalo.
