package graph.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GraphNode {
  public String label;
  public List<GraphEdge> edges = new ArrayList<>();

  public GraphNode(String label) {
    this.label = label;
  }

  public List<GraphEdge> getEdges() {
    this.edges.sort(Comparator.comparing(o -> o.cost));
    return edges;
  }

  public void addAdjacent(GraphNode node, Integer cost) {
    edges.add(new GraphEdge(node, cost));
    node.edges.add(new GraphEdge(this, cost));
  }

  public Set<GraphNode> getAdjacentNodes() {
    return edges.stream().map(edge -> edge.node1)
        .collect(Collectors.toSet());
  }

  public Integer getCostToNode(GraphNode node) {
    return edges.stream()
        .filter(edge -> edge.node1.equals(node))
        .map(edge -> edge.cost).findFirst().get();
  }

  @Override
  public String toString() {
    return label;
  }
}
