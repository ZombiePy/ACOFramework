package project.ant

import project.graph.{Edge, Node}
import project.decision.BaseDecisionAlgorithm
import project.problem.BaseProblem

class BasicAnt(
    startingNode: Node,
    problem: BaseProblem,
    decision: BaseDecisionAlgorithm
) extends BaseAnt(
      startingNode,
      problem,
      decision
    ) {}
