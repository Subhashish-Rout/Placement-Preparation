
// https://leetcode.com/problems/shortest-bridge/submissions/

class Solution {
    class Pair{
        int i;
        int j;
        int level;
        Pair(int i, int j, int level){
            this.i = i;
            this.j = j;
            this.level = level;
        }
    }
    public int shortestBridge(int[][] grid) {
        boolean[][] vis1 = new boolean[grid.length][grid[0].length];
        Queue<Pair> q = new LinkedList<>();
        boolean found = false;
        for(int i = 0 ; i< grid.length ; i++){
           for(int j =0 ; j< grid[0].length ; j++){
               if(grid[i][j] == 1){
                   dfs(grid,vis1,i,j,q);
                   found = true;
                   break;
               }
           }
            if(found){
                break;
            }
       }
        boolean[][] vis2 = new boolean[grid.length][grid[0].length];
        while(q.size()>0){
            int size = q.size();
            for(int i =0 ; i< size ; i++){
                Pair rem = q.remove();
                if(vis2[rem.i][rem.j] == true){
                    continue;
                }
                vis2[rem.i][rem.j] = true;
                if(grid[rem.i][rem.j] == 1){
                    return rem.level-1;
                }
                addN(grid,vis2,rem.i+1,rem.j,q,rem.level);
                addN(grid,vis2,rem.i-1,rem.j,q,rem.level);
                addN(grid,vis2,rem.i,rem.j+1,q,rem.level);
                addN(grid,vis2,rem.i,rem.j-1,q,rem.level);
            }
            
        }
        return -1;
        
    }
    public void addN(int[][] grid,boolean[][] vis,int i, int j, Queue<Pair> q,int level){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||vis[i][j]==true||grid[i][j]==2){
            return;
        }
        q.add(new Pair(i,j,level+1));
    }
    public void dfs(int[][] grid,boolean[][] vis, int i , int j,Queue<Pair> q){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length||vis[i][j] == true||grid[i][j]==0){
            return;
        }
        q.add(new Pair(i,j,0));
        vis[i][j]=true;
        dfs(grid,vis,i+1,j,q);
        dfs(grid,vis,i-1,j,q);
        dfs(grid,vis,i,j+1,q);
        dfs(grid,vis,i,j-1,q);
        grid[i][j] = 2;
    }
}















