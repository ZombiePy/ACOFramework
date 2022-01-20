package project.ant

import project.graph.{Edge, Node}
import project.decision.BaseDecisionAlgorithm
import project.problem.BaseProblem
import project.solution.BaseSolution

class BasicAnt(
    startingNode: Node,
    problem: BaseProblem,
    decision: BaseDecisionAlgorithm,
    val pheromoneWeights: List[Float],
    val distanceWeights: List[Float]
) extends BaseAnt(
      startingNode,
      problem,
      decision
    ) {
  override def run() = {
    while (true) {
      val next_move = decision.decide(visitedNodes)

      if (next_move == None) {
        return evaluateSolution()
      }

      visitedNodes :+ next_move
    }
  }

  override def evaluateSolution(): BaseSolution = {
    new BaseSoltion(visitedNodes, problem.evaluate(visitedNodes))
  }
}
