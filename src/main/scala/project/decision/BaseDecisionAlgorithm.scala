package project.decision

import project.graph.{Edge, Node}

import project.problem.BaseProblem

abstract class BaseDecisionAlgorithm(val problem: BaseProblem) {

  /** Function that make decision for the next ant step Parameters: currentNode
    *   - node that ant is currently in visitedNodes - all visited by ant nodes
    *     in previous steps
    */
  def decide(visitedNodes: List[Node]): Node

}
