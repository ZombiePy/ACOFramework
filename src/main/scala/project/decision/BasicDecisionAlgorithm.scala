package project.decision

import org.graalvm.compiler.graph.Node
import project.pheromone.BasePheromoneTable
import project.problem.BaseProblem

class BasicDecisionAlgorithm (problem: BaseProblem,
                              val pheromoneTable: BasePheromoneTable) extends BaseDecisionAlgorithm (problem) {

  def getPossibleNodes(current_node: Node, visited_nodes: List[Node]): List[Node] = {
    val possible_moves: List[Node] = problem.getPossibleMoves(current_node, visited_nodes)
    return possible_moves
  }

  def getProbabilities(current_node: Node, possible_moves: List[Node]): Map[Node, Float] = {
    /*
    Getting probabilities based on pheromone and cost of edge
     */
    ???
  }

  override def decide(current_node: Node, visited_nodes: List[Node]): Node = {
    val possible_moves = getPossibleNodes(current_node, visited_nodes)

    ???
  }
}
