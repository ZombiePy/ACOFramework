package project.decision

import project.graph.{Edge, Node}
import project.pheromone.BasePheromoneTable
import project.problem.BaseProblem

class BasicDecisionAlgorithm(
    problem: BaseProblem,
    val weights: List[Double],
    val pheromoneTable: BasePheromoneTable
) extends BaseDecisionAlgorithm(problem) {

  // def getPossibleNodes(
  //     visited_nodes: List[Node]
  // ): List[Node] = {
  //   val possible_moves: List[Node] =
  //     problem.getPossibleMoves(visited_nodes).toList
  //   return possible_moves
  // }

  // def assessment(
  //     edgeToPheromone: Map[(CityName, CityName), Double],
  //     edgeToDistance: Map[(CityName, CityName), Double],
  //     alpha: Double,
  //     beta: Double,
  //     notVisied: Seq[CityName]
  // )(edge: Edge): Double = {
  //   val smth = pheromoneTable.getPheromone(edge) zip problem.getDistance(
  //     edge
  //   ) zip weights
  //   val numerator: Double =
  //     Math.pow(pheromoneTable.getPheromone(edge), alpha) * Math.pow(
  //       1.0 / problem.getDistance(edge),
  //       beta
  //     )
  //   val denominator: Double = notVisied.map { l =>
  //     Math.pow(edgeToPheromone(i, l), alpha) * Math.pow(
  //       1.0 / edgeToDistance(i, l),
  //       beta
  //     )
  //   }.sum
  //   numerator / denominator
  // }
  def getProbabilities(
      current_node: Node,
      possible_moves: List[Node]
  ): Map[Node, Float] = {
    // (for {
    //   m <- possible_moves
    // } yield {
    //   val ass: (CityName, CityName) => Double =
    //     assessment(edgeToPheromone, edgeToDistance, alpha, beta, notVisied)
    //   val mAsses: Double = ass(i, m)
    //   val sumAsses: Double = notVisied.map { n => ass(i, n) }.sum
    //   (m, mAsses / sumAsses)
    // }).toMap
    /*
    Getting probabilities based on pheromone and cost of edge
     */
    ???
  }

  override def decide(visited_nodes: List[Node]): Node = {
    // val possible_moves = getPossibleNodes(visited_nodes)

    ???
  }
}
