package project.ant

import project.graph.{Edge, Node}

import project.decision.BaseDecisionAlgorithm
import project.problem.BaseProblem

abstract class BaseAnt(
    startingNode: Node,
    val problem: BaseProblem,
    val decision: BaseDecisionAlgorithm
) {
  var currentNode: Node = startingNode
  var visitedNodes: List[Node] = List()

  def run() = {
    /*
    Function that make decision about next move of ant
    change currentNode to chosen one and add it to visitedNodes list
     */
    ???
  }

  def evaluateSolution(): Float = {
    /*
    Prepare solution from gathered information
    needs to send information to problem to update pheromone
     */
    ???
  }

}
