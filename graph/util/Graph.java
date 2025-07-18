package graph.util;

import java.util.Set;

public class Graph {
  final Set<GraphNode> nodes;

  public Graph(Set<GraphNode> nodes) {
    this.nodes = nodes;
  }

  public Set<GraphNode> getNodes() {
    return nodes;
  }

  public GraphNode getNode(String label) {
    return nodes.stream()
        .filter(n -> n.label.equals(label))
        .findFirst().get();
  }

  public void addNode(GraphNode node) {
    nodes.add(node);
  }
}
