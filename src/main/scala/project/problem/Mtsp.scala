package project.problem
import project.graph.{Edge, Node}
class Mtsp(nodes: List[Node], val matrices: List[Map[Edge, Double]])
    extends BaseProblem(
      nodes,
      edges = matrices.head.map(_._1).toList
    ) {
  val allNodes = nodes.toSet
  assert(allNodes.size == nodes.size)
  override def evaluate(solution: List[Node]): List[Double] = {
    solution
      .sliding(2)
      .map(pair => Edge(pair.head, pair.last))
      .map(edge => matrices.map(matrix => matrix(edge)))
      .toList
      .transpose
      .map(_.sum)

  }

  override def getPossibleMoves(
      visited_nodes: List[Node]
  ): Set[Node] = {
    return allNodes diff visited_nodes.toSet
  }
  override def getHeuristicValue(edge: Edge) =
    matrices.map(matrix => matrix(edge))

}
