package project.ant

import project.graph.{Edge, Node}
import project.decision.BaseDecisionAlgorithm
import project.problem.BaseProblem
import project.solution.BaseSolution
import scala.collection.mutable.ListBuffer

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
    val solution = ListBuffer[Node](problem.nodes.head)
    var dec = decision.decide(
      solution.toList,
      pheromoneWeights,
      distanceWeights
    )
    while (dec.isDefined) {
      solution.append(dec.get)
      dec = decision.decide(
        solution.toList,
        pheromoneWeights,
        distanceWeights
      )
    }
    return BaseSolution(
      solution.toList,
      problem.evaluate(solution.toList)
    )
  }

}
