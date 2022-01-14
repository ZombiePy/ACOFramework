package project.problem
import project.graph.{Edge, Node}
class Mtsp(nodes: List[Node], val matrices: List[Map[(Node, Node), Double]])
    extends BaseProblem(
      nodes,
      edges = (nodes zip nodes.tail).map(pair => Edge(pair._1, pair._2))
    ) {
  override def evaluate(solution: List[Node]): List[Double] = {
    (solution zip solution.tail)
      .map(pair => matrices.map(matrix => matrix(pair)))
      .transpose
      .map(_.sum)
  }

  override def getPossibleMoves(
      current_node: Node,
      visited_nodes: List[Node]
  ): List[Node] = {
    return nodes
  }

}
