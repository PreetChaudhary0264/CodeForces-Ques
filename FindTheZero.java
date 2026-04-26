import java.io.*;

public class FindTheZero {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    // Query function
    static int ask(int i, int j) throws IOException {
        out.println("? " + i + " " + j);
        out.flush(); // VERY IMPORTANT

        int res = Integer.parseInt(br.readLine());
        if (res == -1) System.exit(0); // invalid / exceeded
        return res;
    }

    // Print answer
    static void answer(int k) {
        out.println("! " + k);
        out.flush(); // IMPORTANT
    }

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            //  Example logic (pivot approach)
            int found = -1;

            for (int i = 3; i < 2*n; i+=2) {
                int res = ask(i, i+1);
                if (res == 1) {
                    found = i;
                    break;
                }
            }
            if(found != -1){
                answer(found);
            }else{
                int res1 = ask(1,3);
                int res2 = ask(1,4);
                if(res2 == 1 || res1 == 1){
                    answer(1);
                }else{
                    answer(2);
                }
            }

        }
        out.close();
    }
}
