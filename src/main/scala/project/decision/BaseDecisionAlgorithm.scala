package project.decision


abstract class BaseDecisionAlgorithm (problemToSolve: BaseProblem) {
  private val problem = problemToSolve;

  def decide(currentNode: Node, visitedNodes: List[Node]): Node = {
    /* Function that make decision for the next ant step
    Parameters:
    currentNode - node that ant is currently in
    visitedNodes - all visited by ant nodes in previous steps
     */
  }


}
