// https://leetcode.com/problems/number-of-enclaves/submissions/
// same as number of islands
class Solution {
    boolean flag = true;
    int len = 0;
    public int numEnclaves(int[][] grid) {
        int count = 0;
        for(int i =1; i< grid.length-1 ; i++){
            for(int j =1 ; j < grid[0].length-1 ; j++){
                if(grid[i][j] == 1){
                    flag = true;
                    len = 0;
                    check(grid, i , j);
                    if(flag == true){
                        count+=len;
                    }
                }
            }
        }
        return count;
    }
    public void check(int[][] grid, int i , int j){
        if(i<0||j<0||i>=grid.length||j>=grid[0].length ){
            flag = false;
            return;
        }
        else if(grid[i][j] == 0){
            return;
        }
        len++;
        grid[i][j] = 0;
        check(grid, i+1 , j);
        check(grid, i , j+1);
        check(grid, i , j-1);
        check(grid, i-1 , j);
    }
}