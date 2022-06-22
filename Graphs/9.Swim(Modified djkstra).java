// https://leetcode.com/problems/swim-in-rising-water/submissions/


class Solution {
    class Pair implements Comparable<Pair>{
        int i ;
        int j;
        int tsf;
        Pair(int i, int j, int tsf){
            this.i = i;
            this.j = j;
            this.tsf = tsf;
        }
        public int compareTo(Pair o){
            return this.tsf-o.tsf;
        }
    }
    public int swimInWater(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0,grid[0][0]));
        while(pq.size()>0){
            int size = pq.size();
            while(size>0){
                Pair rem = pq.remove();
                if(vis[rem.i][rem.j] == true){
                    continue;
                }
                vis[rem.i][rem.j] = true;
                if(rem.i == grid.length-1 && rem.j == grid[0].length-1){
                    return rem.tsf;
                }
                add(grid,vis,rem.i-1,rem.j,pq,rem.tsf);
                add(grid,vis,rem.i,rem.j-1,pq,rem.tsf);
                add(grid,vis,rem.i+1,rem.j,pq,rem.tsf);
                add(grid,vis,rem.i,rem.j+1,pq,rem.tsf);
            }
        }
        return -1;
    }
    public void add(int[][] mat, boolean[][] vis, int i ,int j ,PriorityQueue<Pair> q,int level){
        if(i<0||j<0||i>=mat.length || j>= mat[0].length ||vis[i][j] == true){
            return ;
        }
        q.add(new Pair(i,j,Math.max(level,mat[i][j])));
    }
}












