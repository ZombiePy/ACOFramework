package project.problem

import jdk.jshell.spi.ExecutionControl.NotImplementedException
import project.aggregator.BasePheromoneAggregator
import project.pheromone.BasePheromoneTable
import project.graph.{Edge, Node}

abstract class BaseProblem(val nodes: List[Node], val edges: List[Edge]) {

  def evaluate(solution: List[Node]): List[Double] = {
    /*
    Function to evaluate solution in to float
     */
    ???
  }

  def getPossibleMoves(
      current_node: Node,
      visited_nodes: List[Node]
  ): List[Node] = {
    /*
    Function that return all possible moves to ant, based on visited nodes
     */
    ???
  }

}
