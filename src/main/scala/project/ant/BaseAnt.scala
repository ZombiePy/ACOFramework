package project.ant

import org.graalvm.compiler.graph.Node

import project.decision.BaseDecisionAlgorithm
import project.problem.BaseProblem

abstract class BaseAnt (startingNode: Node, problem: BaseProblem, decision: BaseDecisionAlgorithm) {
  var currentNode: Node = startingNode
  val problemToSolve: BaseProblem = problem
  val decisionAlgorithm: BaseDecisionAlgorithm = decision
  var visitedNodes: List[Node]

  def run(): None = {
    /*
    Function that make decision about next move of ant
    change currentNode to chosen one and add it to visitedNodes list
     */
  }

  def evaluateSolution(): Float = {
    /*
    Prepare solution from gathered information
    needs to send information to problem to update pheromone
     */
  }

}
