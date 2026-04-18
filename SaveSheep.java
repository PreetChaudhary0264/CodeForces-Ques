import java.util.*;

public class SaveSheep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();
        sc.nextLine();

        char[][] grid = new char[r][c];

        for(int i = 0; i < r; i++){
            grid[i] = sc.nextLine().toCharArray();
        }

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        // Step 1: Check impossible
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == 'W'){
                    for(int d = 0; d < 4; d++){
                        int ni = i + dx[d];
                        int nj = j + dy[d];

                        if(ni >= 0 && nj >= 0 && ni < r && nj < c){
                            if(grid[ni][nj] == 'S'){
                                System.out.println("No");
                                return;
                            }
                        }
                    }
                }
            }
        }

        // Step 2: Fill dogs
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid[i][j] == '.'){
                    grid[i][j] = 'D';
                }
            }
        }

        // Output
        System.out.println("Yes");
        for(int i = 0; i < r; i++){
            System.out.println(new String(grid[i]));
        }
    }
}