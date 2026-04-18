import java.util.Scanner;

public class TimeDisplayStickers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test-- > 0){
            int n = sc.nextInt();
            String s = sc.next();
            int zeros = 0;
            int ones = 0;
            int middle = 0;
            int last = 0;
            for(char ch : s.toCharArray()){
                if(ch == '0')zeros++;
                else if(ch == '1')ones++;
                else if(ch >= '2' && ch <= '5')middle++;
                else last++;
            }
            boolean changed = true;
            int c = 0;
            while(changed){
                changed = false;
                //find first value of hour
                int hourReq = 2;
                if(zeros > 0){
                    hourReq--;zeros--;
                }else if(ones >= 2){
                    hourReq = 0;ones -= 2;
                }

                if(hourReq == 2)break;//hour ki suruwat krne ke liye 0,1 hai hi nhi
                //find second value of hour
                if(hourReq == 1){
                    if(last > 0){
                        last--;hourReq--;
                    }else if(middle > 0){
                        middle--;hourReq--;
                    }else if(ones > 0){
                        ones--;hourReq--;
                    }else if(zeros > 0){
                        zeros--;hourReq--;
                    }
                }
                if(hourReq != 0)break;   //hour bnane possible hi nhi hai



                int minReq = 2;
                if(middle > 0){
                    middle--;minReq--;
                }else if(ones > 0){
                    ones--;minReq--;
                }else if(zeros > 0){
                    zeros--;minReq--;
                }
                if(minReq == 2)break;


                if(last > 0){
                    last--;minReq--;
                }else if(middle > 0){
                    middle--;minReq--;
                }else if(ones > 0){
                    ones--;minReq--;
                }else if(zeros > 0){
                    zeros--;minReq--;
                }
                if(minReq != 0)break;

                //yha tak aa gye to iska matlab hai ki time stamp bnana possible hai
                changed = true;
                c++;
            }
            System.out.println(c);
        }
    }
}