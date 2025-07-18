package graph;

import java.util.*;

public class Problem2 {
    static class Result {
        /*
         * Complete the 'countReverseEdges' function below.
         *
         * The function is expected to return an INTEGER_ARRAY.
         * The function accepts UNWEIGHTED_INTEGER_GRAPH g as parameter.
         */

        /*
         * For the unweighted graph, <name>:
         *
         * 1. The number of nodes is <name>Nodes.
         * 2. The number of edges is <name>Edges.
         * 3. An edge exists between <name>From[i] and <name>To[i].
         *
         */

        public static List<Integer> countReverseEdges(int gNodes, List<Integer> gFrom, List<Integer> gTo) {
            List<List<int[]>> adj = new ArrayList<>();
            for(int i=0; i<=gNodes; i++) {
                adj.add(new ArrayList<>());
            }
            
            for(int i=0; i<gFrom.size(); i++) {
                int from = gFrom.get(i);
                int to = gTo.get(i);
                adj.get(from).add(new int[]{to,0}); //original direction
                adj.get(to).add(new int[]{from, 1}); //reverse direction => cost = 1
            }
            
            int[] result = new int[gNodes + 1];
            boolean[] visited = new boolean[gNodes +1];
            
            // result for root node 1
            result[1] = dfs1(1, adj, visited);
            
            // re-root to calculate for all other nodes
            Arrays.fill(visited, false);
            dfs2(1, adj, visited, result);
            
            List<Integer> ans = new ArrayList<>();
            for(int i=1; i<=gNodes; i++) {
                ans.add(result[i]);
            }
            
            return ans;
        }
        
        // calculate reversals where node is root
        private static int dfs1(int node, List<List<int[]>> adj, boolean[] visited) {
            visited[node] = true;
            int reversals = 0;
            
            for (int[] edge: adj.get(node)) {
                int neighbor = edge[0];
                int cost = edge[1];
                
                if(!visited[neighbor]) {
                    reversals += cost + dfs1(neighbor, adj, visited);
                }
            }
            
            return reversals;
        }

        //re-root: calculate result for all nodes based on root change
        private static void dfs2(int node, List<List<int[]>> adj, boolean[] visited, int[] result) {
            visited[node] = true;
            
            for(int[] edge: adj.get(node)) {
                int neighbor = edge[0];
                int cost = edge[1];
                
                if(!visited[neighbor]) {
                    //when moving root from node to neighbor
                    //if edge was node -> neighbor (cost=0), we need to reverse it to (i+1)
                    //if edge was neighbor -> node (cost=1), we don't need to reverse it (-1)
                    result[neighbor] = result[node] + (cost == 0 ? 1: -1);
                    dfs2(neighbor, adj, visited, result);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Test case
        int gNodes = 4;
        List<Integer> gFrom = Arrays.asList(1, 2, 3);
        List<Integer> gTo = Arrays.asList(2, 3, 4);
        
        List<Integer> result = Result.countReverseEdges(gNodes, gFrom, gTo);
        System.out.println("Reverse edges count for each node: " + result);
    }
} 