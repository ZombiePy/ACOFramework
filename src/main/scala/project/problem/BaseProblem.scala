package project.problem

import jdk.jshell.spi.ExecutionControl.NotImplementedException
import project.aggregator.BasePheromoneAggregator
import project.pheromone.BasePheromoneTable
import project.graph.{Edge, Node}

abstract class BaseProblem(val nodes: List[Node], val edges: List[Edge]) {

  def evaluate(solution: List[Node]): List[Double] = {
    /*
    Function to evaluate solution into float
     */
    ???
  }
  /*
  Function that return all possible moves to ant, based on visited nodes
  */
  def getPossibleMoves(
      visited_nodes: List[Node]
  ): Set[Node] = {

    ???
  }
  def getHeuristicValue(edge: Edge): List[Double] = {
    /*
    Function to evaluate dinstance between nodes into doubles depending from problem dimension
     */
    ???
  }
}
