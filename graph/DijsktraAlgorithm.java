package graph;

import graph.util.Graph;
import graph.util.GraphBuilder;
import graph.util.GraphEdge;
import graph.util.GraphNode;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
 * https://youtu.be/bZkzH5x0SKU?si=gALcfDXqBALvp_xQ
 */
public class DijsktraAlgorithm {

  /**
   * dijkstra
   */
  public static ShortestPathRegistry findShortestPathToAllNodesFrom(
      final Graph graph,
      final String nodeLabel) {

    final var shortestPath = new ShortestPathRegistry(graph, nodeLabel);
    final Deque<GraphNode> nodes = new LinkedList<>();
    final Set<GraphNode> visited = new HashSet<>();

    nodes.add(graph.getNode(nodeLabel));
    while(!nodes.isEmpty()) {
      var node = nodes.removeFirst();
      visited.add(node);
      node.getEdges()
          .forEach(edge -> {
            if(visited.contains(edge.node1)) {
              return;
            }
            nodes.push(edge.node1);
          });

      for (GraphEdge edge : node.edges) {
        shortestPath.add(node, edge);
      }
    }

    shortestPath.print();
    return shortestPath;
  }

  public static void findShortestPathBetween(
      Graph graph,
      String from, String to) {
    var registry = findShortestPathToAllNodesFrom(graph, from);
    var found = "";
    var toNode = graph.getNode(to);
    StringBuilder path = new StringBuilder();
    path.append(to).append("-");
    var cost = 0;
    while(!from.equals(found)) {
      var fromNode = registry.getCost(toNode).from;
      cost += toNode.getCostToNode(fromNode);
      toNode = fromNode;
      found = toNode.label;
      path.append(found).append("-");
    }
    path.deleteCharAt(path.length()-1);
    path.append(": ");
    path.append(cost);

    System.out.println(path);
  }

  public static void main(String[] args){
    final Graph graph = GraphBuilder.buildGraph();
//    findShortestPathToAllNodesFrom(graph, "A");
    findShortestPathBetween(graph, "A", "C");
  }
}

class ShortestPathRegistry {
  final Map<GraphNode, Cost> registry = new HashMap<>();

  public void add(final GraphNode node0, final GraphEdge edge) {
    var costFrom = getCostValue(node0);
    var costTo = getCostValue(edge.node1);
    var newCost = edge.cost + costFrom;
    if(costTo > newCost) {
      put(edge.node1, node0, newCost);
    }
  }

  public void put(GraphNode node, GraphNode from, Integer cost) {
    this.registry.put(node, new Cost(from, cost));
  }

  public Cost getCost(GraphNode node) {
    return registry.get(node);
  }

  public Integer getCostValue(GraphNode node) {
    return this.registry.get(node).cost;
  }

  public ShortestPathRegistry(Graph graph, String fromLabel) {
    graph.getNodes().forEach(node ->
        this.registry.put(node, new Cost(null,
        fromLabel.equals(node.label) ? 0 : Integer.MAX_VALUE))
    );
  }

  public void print() {
    registry.entrySet().stream().sorted(
        Comparator.comparing(e -> e.getKey().label))
        .map(entry ->
            entry.getKey().label + "-" +
            entry.getValue().cost + "-" +
            entry.getValue().from).forEach(System.out::println);
  }

  class Cost {
    public final GraphNode from;
    public final Integer cost;

    public Cost(GraphNode from, Integer cost) {
      this.from = from;
      this.cost = cost;
    }
  }
}

