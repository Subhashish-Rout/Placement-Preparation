class Solution {
    StringBuilder psf = new StringBuilder();
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        for(int i =0 ; i< grid.length ; i++){
            for(int j =0 ; j< grid[0].length ; j++){
                if(grid[i][j] == 1 && visited[i][j] == false){
                    psf = new StringBUilder();
                    traverse(grid,visited,i,j);
                    set.add(psf.toString());
                }
            }
        }
        return set.size();
    }
    public static void traverse(int[][] grid, int[][] visited, int i , int j){
        visited[i][j] = true;
        if(i-1>=0 && visited[i-1][j] == false && grid[i-1][j] == 1){
            psf.add("N");
            traverse(grid,visited,i-1,j);
        }
        if(j-1>=0 && visited[i][j-1] == false && grid[i][j-1] == 1){
            psf.add("W");
            traverse(grid,visited,i,j-1);
        }
        if(i+1<grid.length && visited[i+1][j] == false && grid[i+1][j] == 1){
            psf.add("S");
            traverse(grid,visited,i+1,j);
        }
        if(j+1<grid[0].length && visited[i][j+1] == false && grid[i][j+1] == 1){
            psf.add("E");
            traverse(grid,visited,i,j+1);
        }
        psf.add("B");
    }
}