package project.problem
import project.graph.{Edge, Node}
class Mtsp(nodes: List[Node], val matrices: List[Map[(Node, Node), Double]])
    extends BaseProblem(
      nodes,
      edges = (nodes zip nodes.tail).map(pair => Edge(pair._1, pair._2))
    ) {
  val allNodes = nodes.toSet
  assert(allNodes.size == nodes.size)
  override def evaluate(solution: List[Node]): List[Double] = {
    (solution zip solution.tail)
      .map(pair => matrices.map(matrix => matrix(pair)))
      .transpose
      .map(_.sum)
  }

  override def getPossibleMoves(
      visited_nodes: List[Node]
  ): Set[Node] = {
    return allNodes diff visited_nodes.toSet
  }
  override def getDistance(edge: Edge) =
    matrices.map(matrix => matrix((edge.node1, edge.node2)))

}
