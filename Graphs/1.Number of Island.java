// https://leetcode.com/problems/number-of-islands/submissions/
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i =0 ; i< grid.length ; i++){
            for(int j =0 ; j< grid[0].length ; j++){
                if(grid[i][j] == '1'){
                    count++;
                    count(grid,i,j);
                }
            }
        }
        return count;
    }
    public void count(char[][] grid , int i , int j){
        if(i <0 || j< 0 ||i>=grid.length || j>= grid[0].length || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        count(grid,i+1,j);
        count(grid,i,j+1);
        count(grid,i-1,j);
        count(grid,i,j-1);
    }
}