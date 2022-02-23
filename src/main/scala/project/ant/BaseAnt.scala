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

  /** Function that make decision about next move of ant change currentNode to
    * chosen one and add it to visitedNodes list
    */
  def run(): BaseSolution
}
