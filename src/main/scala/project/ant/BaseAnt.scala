package project.ant

import project.graph.{Edge, Node}

import project.decision.BaseDecisionAlgorithm
import project.problem.BaseProblem
import project.solution.BaseSolution

abstract class BaseAnt(
    startingNode: Node,
    val problem: BaseProblem,
    val decision: BaseDecisionAlgorithm
) {
  var currentNode: Node = startingNode
  var visitedNodes: List[Node] = List()

  /** Function that make decision about next move of ant change currentNode to
    * chosen one and add it to visitedNodes list
    */
  def run(): BaseSolution

  /** Prepare solution from gathered information needs to send information to
    * problem to update pheromone
    */
  def evaluateSolution(): BaseSolution

}
