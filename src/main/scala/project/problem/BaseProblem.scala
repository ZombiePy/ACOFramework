package project.problem

import jdk.jshell.spi.ExecutionControl.NotImplementedException
import project.aggregator.BasePheromoneAggregator
import project.graph.{Edge, Node}

abstract class BaseProblem(val nodes: List[Node], val edges: List[Edge]) {

  /** Function to evaluate solution into list of double
    */
  def evaluate(solution: List[Node]): List[Double]

  /** Function that return all possible moves to ant, based on visited nodes
    */
  def getPossibleMoves(
      visited_nodes: List[Node]
  ): Set[Node]

  /** Function to evaluate distance between nodes into doubles depending from
    * problem dimension
    */
  def getHeuristicValue(edge: Edge): List[Double]
}
