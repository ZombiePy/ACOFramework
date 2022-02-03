package project.decision

import project.graph.{Edge, Node}
import project.pheromone.BasePheromoneTable
import project.problem.BaseProblem
import scala.util.Random
class BasicDecisionAlgorithm(
    alpha: Double,
    beta: Double,
    problem: BaseProblem,
    pheromoneTable: BasePheromoneTable,
    val random: Random
) extends BaseDecisionAlgorithm(problem) {

  /** calculate heuristic and pheromone value in standard way
    */
  def other_asses(
      alpha: Double,
      beta: Double,
      pheromoneWeights: List[Double],
      distanceWeights: List[Double]
  )(edge: Edge): Double = {
    val pheromone =
      pheromoneTable.getPheromone(edge).zip(pheromoneWeights).map(_ * _).sum
    val heuristic =
      problem.getHeuristicValue(edge).zip(distanceWeights).map(_ * _).sum
    Math.pow(pheromone, alpha) * Math.pow(
      1.0 / heuristic,
      beta
    )
  }
  override def decide(
      visitedNodes: List[Node],
      pheromoneWeights: List[Double],
      distanceWeights: List[Double]
  ): Node = {
    val initialized_asses =
      other_asses(alpha, beta, pheromoneWeights, distanceWeights)
    val possibleMoves = problem
      .getPossibleMoves(visitedNodes)
      .toList
      .map(Edge(visitedNodes.last, _))
      .map(edge => (edge, initialized_asses(edge)))

    val sumOfWeights = possibleMoves.map(_._2).sum
    val selected_random = random.nextDouble() * sumOfWeights
    var sum = 0.0
    for { (move, weight) <- possibleMoves } {
      sum += weight
      if (selected_random < weight) {
        return move.node2
      }
    }
    throw new RuntimeException("Impossible state during deciding!")
  }
}
