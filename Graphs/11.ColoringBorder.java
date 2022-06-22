// https://leetcode.com/problems/coloring-a-border/submissions/

class Solution {
    class Pair{
        int i;
        int j;
        boolean border;
        Pair(int i, int j){
            this.i =i;
            this.j = j;
        }
    }
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int orgc = grid[row][col];
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        Queue<Pair> q= new LinkedList<>();
        Pair p = new Pair(row,col);
        p.border = isBorder(grid,row,col);
        q.add(p);
        ArrayList<Pair> list = new ArrayList<>();
        while(q.size()>0){
            int size = q.size();
            for(int i = 0 ; i< size ; i++){
                Pair rem = q.remove();
                if(vis[rem.i][rem.j] == true){
                    continue;
                }
                vis[rem.i][rem.j] = true;
                list.add(rem);
                addN(rem.i+1,rem.j,grid,vis,orgc,q);
                addN(rem.i,rem.j+1,grid,vis,orgc,q);
                addN(rem.i-1,rem.j,grid,vis,orgc,q);
                addN(rem.i,rem.j-1,grid,vis,orgc,q);
            }
        }
        for(Pair pair : list){
            if(pair.border == true){
                grid[pair.i][pair.j] = color;
            }
        }
        return grid;
    }
    public void addN(int i,int j,int[][] grid,boolean[][] vis, int orgc,Queue<Pair> q){
        if(i<0||j<0||i>=grid.length || j>=grid[0].length|| vis[i][j] == true || grid[i][j] != orgc){
            return;
        }
        Pair p = new Pair(i,j);
        p.border = isBorder(grid,i,j);
        q.add(p);
    }
    public boolean isBorder(int[][] grid, int i, int j){
        if(i == 0|| j == 0 || i== grid.length-1 || j== grid[0].length-1){
            return true;
        }else{
            int color = grid[i][j];
            if(grid[i-1][j] != color){
                return true;
            }else if(grid[i+1][j] != color){
                return true;
            }else if(grid[i][j-1] != color){
                return true;
            }else if(grid[i][j+1] != color){
                return true;
            }else{
                return false;
            }
        }
        
    }
}