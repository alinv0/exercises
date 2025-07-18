package graph.util;

import java.util.Arrays;
import java.util.HashSet;


public class GraphBuilder {


  /**
   *
   *          B - E
   *        / |  /| \
   *      A   | / |  C
   *        \ |/  | /
   *          D - F
   *
   * AB = 2; AD = 8
   * BD = 5; BE = 6
   * DE = 3; DF = 1
   * EF = 1; EC = 9
   * FC = 3
   *
   * @return
   */

  public static Graph buildGraph() {
    var nodeA = new GraphNode("A");
    var nodeB = new GraphNode("B");
    var nodeC = new GraphNode("C");
    var nodeD = new GraphNode("D");
    var nodeE = new GraphNode("E");
    var nodeF = new GraphNode("F");

    nodeA.addAdjacent(nodeB, 2);
    nodeA.addAdjacent(nodeD, 8);

    nodeB.addAdjacent(nodeD, 5);
    nodeB.addAdjacent(nodeE, 6);

    nodeC.addAdjacent(nodeE, 9);
    nodeC.addAdjacent(nodeF, 3);

    nodeD.addAdjacent(nodeE, 3);
    nodeD.addAdjacent(nodeF, 2);

    nodeE.addAdjacent(nodeF, 1);

    return new Graph(new HashSet<>(Arrays.asList(
        nodeA, nodeB, nodeC, nodeD, nodeE, nodeF
    )));
  }
}
