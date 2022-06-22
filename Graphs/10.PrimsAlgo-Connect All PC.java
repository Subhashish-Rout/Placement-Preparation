import java.io.*;
import java.util.*;

//prims is nothing but modified djsktra in which we visit every node just dont add the sum of the path add 
//individually
public class Main {
    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    static class Pair implements Comparable <Pair>{
        int v;
        int p;
        int w;
        Pair(int v, int p, int w){
            this.v = v;
            this.p = p;
            this.w = w;
        }
        public int compareTo(Pair o) {
            return this.w - o.w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vtces = Integer.parseInt(br.readLine());
        ArrayList < Edge > [] graph = new ArrayList[vtces];
        for (int i = 0; i < vtces; i++) {
            graph[i] = new ArrayList < > ();
        }

        int edges = Integer.parseInt(br.readLine());
        for (int i = 0; i < edges; i++) {
            String[] parts = br.readLine().split(" ");
            int v1 = Integer.parseInt(parts[0]);
            int v2 = Integer.parseInt(parts[1]);
            int wt = Integer.parseInt(parts[2]);
            graph[v1].add(new Edge(v1, v2, wt));
            graph[v2].add(new Edge(v2, v1, wt));
        }
        boolean visited[] = new boolean[vtces];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,-1,0));
        while(pq.size()>0){
            Pair rem = pq.remove();
            if(visited[rem.v] == true){
                continue;
            }
            visited[rem.v] = true;
            if(rem.p > -1){
                System.out.println("["+rem.v+"-"+rem.p+"@"+rem.w+"]");
            }
            for(Edge e: graph[rem.v]){
                if(visited[e.nbr] == false){
                    pq.add(new Pair(e.nbr,rem.v,e.wt));
                }
            }
        }
    }

}