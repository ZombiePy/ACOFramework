package project.decision

import project.graph.{Edge, Node}
import project.problem.BaseProblem

class BasicDecisionAlgorithm(problem: BaseProblem)
    extends BaseDecisionAlgorithm(problem) {

  def getPossibleNodes(
      current_node: Node,
      visited_nodes: List[Node]
  ): List[Node] = {
    ???
  }

}
