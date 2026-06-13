package ImpTemplates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Q3559 {

    static int[][] findAncestors(Map<Integer, List<Integer>> mpp, int nodes){
        int jumps = (int)(Math.log(nodes) / Math.log(2));
        int[][] ancestors = new int[nodes+1][jumps+1];
        for(int[] r : ancestors) Arrays.fill(r,-1);
        fillBaseCase(ancestors,mpp,1,-1);
        for(int j = 1; j <= jumps; j++){
            for(int i = 1; i <= nodes; i++){
                if(ancestors[i][j-1] != -1){
                    ancestors[i][j] = ancestors[ancestors[i][j-1]][j-1];
                }
            }
        }
        return ancestors;
    }
    private static void fillBaseCase(int[][] ancestors, Map<Integer, List<Integer>> mpp, int u, int parent){
        ancestors[u][0] = parent;
        for(int v : mpp.getOrDefault(u,new ArrayList<>())){
            if(v == parent) continue;
            fillBaseCase(ancestors,mpp,v,u);
        }
    }
    private int findLCA(int u,int v,int jump,int[][] ancestors){
        if(u == v) return u;
        for(int j = jump; j >= 0; j--){
            if(ancestors[u][j] == -1 || ancestors[v][j] == -1)continue;
            if(ancestors[u][j] != ancestors[v][j]){
                u = ancestors[u][j];
                v = ancestors[v][j];
            }
        }
        return ancestors[u][0];  //this will give us the LCA
    }
    private int makeEqualDepth(int diff,int u,int jumps,int[][] ancestors){
        for(int j = 0; j <= jumps; j++){
            if(((diff >> j) & 1) == 1){
                u = ancestors[u][j];
            }
        }
        return u;
    }
}
