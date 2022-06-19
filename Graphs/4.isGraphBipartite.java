// for solving is bipartite add alternate colors to neighbours easy and if cycle is present and it is even then only the grapg is bipartite to check this in bfs when visited the cell second time check if the color before is same as the color you are assigning now
class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        for(int i =0 ; i< graph.length ; i++){
            if(visited[i] == 0){
                boolean isboolean = isbipartite(graph, visited, i);
                if(isboolean == false){
                    return false;
                }
            }
        }
        return true;
    }
    class Pair{
        int val;
        int color;
        Pair(int val , int color){
            this.val = val;
            this.color = color;
        }
    }
    public boolean isbipartite(int[][] graph, int[] visited, int idx){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(idx,1));
        while(q.size()>0){
            int size = q.size();
            for(int i =0 ; i< size ; i++){
                //remove;
                Pair rem = q.remove();
                //mark*
                if(visited[rem.val] != 0){
                    int oc = visited[rem.val];
                    int nc = rem.color;
                    if(oc==nc){
                        continue;
                    }
                    return false;
                }
                visited[rem.val] = rem.color;
                
                //add*
                for(int nbr : graph[rem.val]){
                    if(visited[nbr] == 0){
                        q.add(new Pair(nbr,rem.color*-1));
                    }
                }
            }
        }
        return true;
    }
    public boolean isbipartiteDFS(int[][] graph, int[] visited, int idx, int color){
        visited[idx] = color;
        for(int nbr : graph[idx]){
            if(visited[nbr] == 0){
                boolean isbip = isbipartiteDFS(graph,visited,nbr,color*-1);
                if(isbip == false){
                    return false;
                }
            }else{
                int oc = visited[nbr];
                int nc = visited[idx]*-1;
                if(oc != nc){
                    return false;
                }
            }
        }
        return true;
    }
}














