package graph;

// https://leetcode.com/problems/evaluate-division

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EvaluateDivision {
  static class Solution {

    static class Edge {
      public String node1;
      public String node2;
      public Double cost;

      public Edge(String node1, String node2, Double cost) {
        this.node1 = node1;
        this.node2 = node2;
        this.cost = cost;
      }
    }

    private List<Edge> relations = new ArrayList<>();
    private Set<String> variables = new HashSet<>();

    private void populateRelationList(List<List<String>> equations, double[] values) {
      for (int i = 0; i < equations.size(); i++) {
        var equation = equations.get(i);
        var term1 = equation.get(0);
        var term2 = equation.get(1);
        var value = values[i];

        relations.add(new Edge(term1, term2, value));
        relations.add(new Edge(term2, term1, 1/value));
        variables.add(term1);
        variables.add(term2);
      }

      System.out.println(relations);
    }

    private double dfs(String a, String b, double cost, Set<String> visited) {
      if(!variables.contains(a) || !variables.contains(b)) {
        return -1.0;
      }

      if (a.equals(b)) return cost;
      visited.add(a);
      for (Edge edge : relations) {
        var node1 = edge.node1;
        var node2 = edge.node2;
        if (node1.equals(a) && !visited.contains(node2)) {
          double result = dfs(edge.node2, b, cost * edge.cost, visited);
          if (result != -1.0) return result;
        }
      }
      return -1.0;
    }

    public double[] calcEquation(
        List<List<String>> equations, double[] values, List<List<String>> queries) {
      populateRelationList(equations, values);
      double[] result = new double[queries.size()];
      for (int i = 0; i < queries.size(); i++) {
        var query = queries.get(i);
        var a = query.get(0);
        var b = query.get(1);
        result[i] = dfs(a, b, 1.0, new HashSet<>());
      }
      return result;
    }
  }

  public static void main(String[] args) {
    // equations = [["a","b"],["b","c"]],
    // values = [2.0,3.0],
    // queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]

    System.out.println(
        Arrays.toString(
            new Solution()
                .calcEquation(
                    List.of(List.of("a", "b"), List.of("b", "c")),
                    new double[] {2.0, 3.0},
                    List.of(
                        List.of("a", "c"),
                        List.of("b", "a"),
                        List.of("a", "e"),
                        List.of("a", "a"),
                        List.of("x", "x")))));
  }
}
