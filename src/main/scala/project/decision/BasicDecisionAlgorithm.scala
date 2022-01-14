package project.decision

import org.graalvm.compiler.graph.{Edges, Node}
import project.pheromone.BasePheromoneTable
import project.problem.BaseProblem

class BasicDecisionAlgorithm (problem: BaseProblem,
                              pheromoneTable: BasePheromoneTable)
  extends BaseDecisionAlgorithm (problem, pheromoneTable) {

  def getProbabilities(current_node: Node, possibleMoves: List[Edges]): Map[Edges, Float] = {
    /*
    Getting probabilities based on pheromone and cost of edge
     */

  }

  override decide(possibleMoves: List[Edges]): Edges = {


    ???
  }
}
