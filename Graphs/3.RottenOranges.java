
// https://leetcode.com/problems/rotting-oranges/

class Solution {
    class Pair{
        int i;
        int j;
        int t;
        Pair(int i , int j , int t){
            this.i = i;
            this.j = j;
            this.t = t;
        }
    }
    //queue mwin bas wo sab daal do = 2 wale jo pehle se kharab ho chuke ye time = 0 pe kharap hogye h
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;
        for(int i =0;i<grid.length ; i++){
            for(int j =0 ; j< grid[0].length ; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        int time = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        while(q.size()>0){
            int size = q.size();
            for(int i =0 ; i< size ; i++){
                //remove
                Pair temp = q.remove();
                //mark*
                //agar wo pehle kam time pe kharap ho chuka h to humko aur kuch nahi karna
                if(visited[temp.i][temp.j] == true){
                    continue;
                }
                visited[temp.i][temp.j] = true;
                //work
                //agar mera remove wala time mere global time se bada h to time badha do
                if(temp.t>time){
                    time = temp.t;
                }
                //only decrease fresh if it was a fresh orange before
                if(grid[temp.i][temp.j] == 1){
                    fresh--;    
                }
                
                //add*
                addstar(visited,grid,temp.i-1,temp.j,q,temp.t);
                addstar(visited,grid,temp.i+1,temp.j,q,temp.t);
                addstar(visited,grid,temp.i,temp.j-1,q,temp.t);
                addstar(visited,grid,temp.i,temp.j+1,q,temp.t);
            }
        }
        if(fresh>0){
            return -1;
        }
        return time;
    }
    public void addstar(boolean[][] visited, int[][] grid, int i , int j,Queue<Pair> q,int t ){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length){
            return;
            //agar wo pehle se visited h matlab khrap ho chuka h to usko add mat karo
        }else if(visited[i][j] == true || grid[i][j] == 0){
            return;
        }
        q.add(new Pair(i,j,t+1));
        
    }
}














