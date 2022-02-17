package project.problem
import project.graph.{Edge, Node}

class TspProblem(nodes: List[Node], val matrix: Map[Edge, Double])
    extends BaseProblem(
      nodes,
      edges = matrix.map(_._1).toList
    ) {
  val allNodes = nodes.toSet
  assert(allNodes.size == nodes.size)

  override def evaluate(solution: List[Node]): List[Double] = {
    val evaluation = solution
                      .sliding(2)
                      .map(pair => Edge(pair.head, pair.last))
                      .map(edge => matrix(edge))
                      .toList
                      .sum
    List[Double](evaluation)
  }

  override def getPossibleMoves(
      visited_nodes: List[Node]
  ): Set[Node] = {
     allNodes diff visited_nodes.toSet
  }
  
  override def getHeuristicValue(edge: Edge) = {
    val value = matrix(edge)
    List[Double](value)
  }

}