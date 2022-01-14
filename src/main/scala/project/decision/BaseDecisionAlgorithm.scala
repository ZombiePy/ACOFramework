package project.decision

import org.graalvm.compiler.graph.{Edges, Node}
import project.pheromone.BasePheromoneTable
import project.problem.BaseProblem

abstract class BaseDecisionAlgorithm (val problem: BaseProblem,
                                      val pheromoneTable: BasePheromoneTable) {

  def decide(possibleMoves: List[Edges]): Edges = {
    /* Function that make decision for the next ant step
    Parameters:
    currentNode - node that ant is currently in
    visitedNodes - all visited by ant nodes in previous steps
     */
    ???
  }


}
