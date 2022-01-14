package project.problem

import jdk.jshell.spi.ExecutionControl.NotImplementedException
import org.graalvm.compiler.graph.Edges
import org.graalvm.compiler.graph.Node
import project.aggregator.BasePheromoneAggregator
import project.pheromone.BasePheromoneTable

abstract class BaseProblem (val nodes: List[Node],
                            val edges: List[Edges]) {

  def evaluate(solution: List[Node]) = {
    /*
    Function to evaluate solution in to float
     */
    ???
  }

  def getPossibleMoves(current_node: Node, visited_nodes: List[Node]): List[Edges] = {
    /*
    Function that return all possible moves to ant, based on visited nodes
     */
    ???
  }

}
