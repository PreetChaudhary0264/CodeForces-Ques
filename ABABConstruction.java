import java.util.Scanner;

public class ABABConstruction{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        while(test-- > 0){
            int n = sc.nextInt();
            char[] x = sc.next().toCharArray();
            boolean isValid = true;
            int reqa = (n+1) / 2;
            int reqb = n / 2;

            for(char ch : x){
                if(ch == 'a')reqa--;
                else if(ch == 'b') reqb--;
            }
            if(reqa < 0 || reqb < 0){
                isValid = false;
            }
            for(int i = 0; i < n; i++) {
                char ch = x[i];
                //even ke liye suru ke 2 same nhi hone chaiye baaki kuch bhi chl jayga
                if(n % 2 == 0){
                    if(i == 1 && ch == x[i-1]){   //even length me suru ke 2 char kbhi same nhi ho skte
                        isValid = false;
                        break;
                    }
                }else{  //odd case me bc first char a hona chaiye baaki kisi bhi order me valid hai
                    if(i == 0 && ch == 'b'){  //pehla character hmesha a hona chaiye off case me
                        isValid = false;
                        break;
                    }
                }

                if(ch == '?' && i > 0){
                    if(x[i-1] == 'a'){
                        if(reqb > 0){x[i] = 'b';reqb--;}  //koshish kro opposite daalne ki pehle
                        else if(reqa > 0){x[i] = 'a';reqa--;}  //agar opp nhi possible hai to same hi daaldo
                    }else{
                        if(reqa > 0){x[i] = 'a';reqa--;}
                        else if(reqb > 0){x[i] = 'b';reqb--;}
                    }
                }else if(ch == '?' && i == 0){
                    if(n % 2 != 0)x[0] = 'a';
                    else {
                        if(reqa > 0)x[0] = 'a';
                        else if(reqb > 0)x[0] = 'b';
                    }
                }


                if(i-1 > 0 && ch == x[i-1] && ch == x[i-2]){  //lgatar 3 kbhi valid nhi ho skte kisi bhi case me odd ho ya even
                    isValid = false;
                    break;
                }
            }
            if(isValid) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}