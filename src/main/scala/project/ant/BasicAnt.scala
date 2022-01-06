package project.ant

import org.graalvm.compiler.graph.Node
import project.decision.BaseDecisionAlgorithm
import project.problem.BaseProblem

class BasicAnt (startingNode: Node,
                problem: BaseProblem,
                decision: BaseDecisionAlgorithm)
  extends BaseAnt (
    startingNode,
    problem,
    decision
  ){


}
