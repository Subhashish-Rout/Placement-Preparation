// https://leetcode.com/problems/as-far-from-land-as-possible/
class Solution {
    class Pair{
        int i;
        int j;
        int level;
        Pair(int i, int j , int level){
            this.i = i;
            this.j = j;
            this.level = level;
        }
    }
    public int maxDistance(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        Queue<Pair> q = new LinkedList<>();
        int count = 0;
        for(int i =0 ; i< grid.length ; i++){
            for(int j =0 ; j< grid[0].length ; j++){
                if(grid[i][j] == 1){
                    q.add(new Pair(i,j,0));
                }else{
                    count++;
                }
            }
        }
        if(count == 0 || count == grid.length*grid[0].length){
            return -1;
        }
        int dist = -1;
        while(q.size()>0){
            int size = q.size();
            for(int i =0 ; i< size ; i++){
                Pair rem = q.remove();
                if(vis[rem.i][rem.j] == true){
                    continue;
                }
                vis[rem.i][rem.j] = true;
                dist = Math.max(dist,rem.level);
                add(grid,vis,rem.i-1,rem.j,q,rem.level);
                add(grid,vis,rem.i,rem.j-1,q,rem.level);
                add(grid,vis,rem.i+1,rem.j,q,rem.level);
                add(grid,vis,rem.i,rem.j+1,q,rem.level);
            }
        }
        return dist;
    }
    public void add(int[][] grid, boolean[][] vis, int i ,int j ,Queue<Pair> q,int level){
        if(i<0||j<0||i>=grid.length || j>= grid[0].length ||vis[i][j] == true || grid[i][j] == 1){
            return ;
        }
        q.add(new Pair(i,j,level+1));
    }
}






















