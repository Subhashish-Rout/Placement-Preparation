// https://leetcode.com/problems/01-matrix/


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
    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> q = new LinkedList<>();
        int[][] ans = new int[mat.length][mat[0].length];
        boolean[][] vis = new boolean[mat.length][mat[0].length];
        for(int i =0 ; i< mat.length ; i++){
            for(int j =0 ; j < mat[0].length ; j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i,j,0));
                }
            }
        }
        while(q.size()>0){
            int size = q.size();
            for(int i =0 ; i< size; i++){
                Pair rem = q.remove();
                if(vis[rem.i][rem.j] == true){
                    continue;
                }
                vis[rem.i][rem.j] = true;
                //work
                ans[rem.i][rem.j] = rem.level;
                //add*
                add(mat,vis,rem.i-1,rem.j,q,rem.level);
                add(mat,vis,rem.i,rem.j-1,q,rem.level);
                add(mat,vis,rem.i+1,rem.j,q,rem.level);
                add(mat,vis,rem.i,rem.j+1,q,rem.level);
            }
        }
        return ans;
    }
    public void add(int[][] mat, boolean[][] vis, int i ,int j ,Queue<Pair> q,int level){
        if(i<0||j<0||i>=mat.length || j>= mat[0].length ||vis[i][j] == true || mat[i][j] == 0){
            return ;
        }
        q.add(new Pair(i,j,level+1));
    }
}

















