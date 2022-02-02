package project.ant

import project.graph.{Edge, Node}
import project.decision.BaseDecisionAlgorithm
import project.problem.BaseProblem
import project.solution.BaseSolution

class BasicAnt(
    startingNode: Node,
    problem: BaseProblem,
    decision: BaseDecisionAlgorithm,
    val pheromoneWeights: List[Double],
    val distanceWeights: List[Double]
) extends BaseAnt(
      startingNode,
      problem,
      decision
    ) {
  override def run() = {
    while (true) {
      val next_move =
        decision.decide(visitedNodes, pheromoneWeights, distanceWeights)

      // if (next_move == None) {
      //   return evaluateSolution()
      // }

      visitedNodes :+ next_move
    }
    ???
  }

  override def evaluateSolution(): BaseSolution = {
    ???
    // new BaseSolution(visitedNodes, problem.evaluate(visitedNodes))
  }
}
