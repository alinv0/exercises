package graph.util;

public class GraphEdge {
  public GraphNode node1;
  public Integer cost;

  public GraphEdge(final GraphNode node1, final Integer cost) {
    this.node1 = node1;
    this.cost = cost;
  }
}
