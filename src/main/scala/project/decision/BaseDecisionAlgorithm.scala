package project.decision

import org.graalvm.compiler.graph.Node

import project.problem.BaseProblem

abstract class BaseDecisionAlgorithm ( val problem: BaseProblem) {

  def decide(currentNode: Node, visitedNodes: List[Node]): Node = {
    /* Function that make decision for the next ant step
    Parameters:
    currentNode - node that ant is currently in
    visitedNodes - all visited by ant nodes in previous steps
     */
    ???
  }


}