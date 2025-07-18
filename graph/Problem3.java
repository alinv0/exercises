package graph;

/**
 * Problem: Count Reverse Edges
Problem Statement:
Given a directed tree with n nodes (numbered 1 to n) and n-1 directed edges, for each node as a potential root, calculate the minimum number of edges that need to be reversed to make all other nodes reachable from that root.
Input:
gNodes: An integer representing the number of nodes in the tree
gFrom: A list of integers representing the source nodes of each directed edge
gTo: A list of integers representing the destination nodes of each directed edge
Output:
A list of integers where the i-th element represents the minimum number of edge reversals needed when node (i+1) is the root
Constraints:
The graph is a tree (connected and acyclic)
1 ≤ n ≤ 10^5
All nodes are numbered from 1 to n
Examples:
Example 1:
Input: 
- gNodes = 3
- gFrom = [2, 1, 2] 
- gTo = [1, 3, 3]
- Edges: 2→1, 1→3, 2→3

Output: [1, 0, 1]
Explanation:
- Root 1: Need to reverse edge 2→1 to make 1→2, total reversals = 1
- Root 2: All nodes reachable (2→1, 2→3, 1→3), total reversals = 0  
- Root 3: Need to reverse edge 1→3 to make 3→1, total reversals = 1

Example 2:
Input:
- gNodes = 4
- gFrom = [1, 2, 3]
- gTo = [2, 3, 4]  
- Edges: 1→2, 2→3, 3→4

Output: [0, 1, 2, 3]
Explanation:
- Root 1: All reachable in original direction, reversals = 0
- Root 2: Reverse 1→2, reversals = 1
- Root 3: Reverse 1→2, 2→3, reversals = 2
- Root 4: Reverse all edges, reversals = 3

Algorithm Approach:
The solution uses a re-rooting technique:
Calculate the answer for an arbitrary root (node 1)
Use DFS to propagate the solution to all other nodes by considering how the answer changes when moving the root from parent to child
Time complexity: O(n), Space complexity: O(n)
*/

import java.util.*;

public class Problem3 {
  static class Solution {
    public static List<Integer> countReverseEdges(int gNodes, List<Integer> gFrom, List<Integer> gTo) {
      // Build adjacency list - treat as undirected but track original edge direction
      List<List<int[]>> adj = new ArrayList<>();
      for (int i = 0; i <= gNodes; i++) {
        adj.add(new ArrayList<>());
      }
      
      // Add edges with direction info
      // [neighbor, cost] where cost = 0 means original direction, cost = 1 means reverse needed
      for (int i = 0; i < gFrom.size(); i++) {
        int from = gFrom.get(i);
        int to = gTo.get(i);
        adj.get(from).add(new int[]{to, 0}); // Original direction, no cost
        adj.get(to).add(new int[]{from, 1});   // Reverse direction, cost = 1
      }
      
      int[] result = new int[gNodes + 1];
      boolean[] visited = new boolean[gNodes + 1];
      
      // Calculate result for root node 1
      result[1] = dfs1(1, adj, visited);
      
      // Re-root to calculate for all other nodes
      Arrays.fill(visited, false);
      dfs2(1, adj, visited, result);
      
      // Convert to list (1-indexed to 0-indexed)
      List<Integer> ans = new ArrayList<>();
      for (int i = 1; i <= gNodes; i++) {
        ans.add(result[i]);
      }
      
      return ans;
    }
    
    // Calculate reversals needed when node is root
    private static int dfs1(int node, List<List<int[]>> adj, boolean[] visited) {
      visited[node] = true;
      int reversals = 0;
      
      for (int[] edge : adj.get(node)) {
        int neighbor = edge[0];
        int cost = edge[1];
        
        if (!visited[neighbor]) {
          reversals += cost + dfs1(neighbor, adj, visited);
        }
      }
      
      return reversals;
    }
    
    // Re-root technique: calculate result for all nodes based on root change
    private static void dfs2(int node, List<List<int[]>> adj, boolean[] visited, int[] result) {
      visited[node] = true;
      
      for (int[] edge : adj.get(node)) {
        int neighbor = edge[0];
        int cost = edge[1];
        
        if (!visited[neighbor]) {
          // When moving root from node to neighbor:
          // If edge was node->neighbor (cost=0), now we need to reverse it (+1)
          // If edge was neighbor->node (cost=1), now we don't need to reverse it (-1)
          result[neighbor] = result[node] + (cost == 0 ? 1 : -1);
          dfs2(neighbor, adj, visited, result);
        }
      }
    }
  }

  public static void main(String[] args){
    Solution s = new Solution();
    
    // Test with the given example
    List<Integer> gFrom = Arrays.asList(2, 1, 2);
    List<Integer> gTo = Arrays.asList(1, 3, 3);
    List<Integer> result = Solution.countReverseEdges(3, gFrom, gTo);
    System.out.println(result); // Should output [1, 0, 1]

    List<Integer> gFrom1 = Arrays.asList(1, 2, 3);
    List<Integer> gTo1 = Arrays.asList(2, 3, 4);
    List<Integer> result1 = Solution.countReverseEdges(4, gFrom1, gTo1);
    System.out.println(result1); // Should output [1, 0, 1]
  }
} 