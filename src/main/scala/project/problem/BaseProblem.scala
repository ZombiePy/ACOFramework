package project.problem

import org.graalvm.compiler.graph.Edges
import org.graalvm.compiler.graph.Node
import project.aggregator.BasePheromoneAggregator
import project.pheromone.BasePheromoneTable

abstract class BaseProblem (val nodes: List[Node],
                            val edges: List[Edges],
                            val pheromone_aggregator: BasePheromoneAggregator) {
  var pheromone_table: BasePheromoneTable = new BasePheromoneTable(edges)

  def evaluate(solution: List[Node]) = {
    /*
    Function to evaluate solution in to single float
     */
  }

  def pheromoneUpdate() = {
    /*
    Function to update pheromone after run based on solution repository
     */
  }

  def getPossibleMoves(current_node: Node, visited_nodes: List[Node]): List[Node] = {
    /*
    Function that return all possible moves to ant, based on visited nodes
     */
  }

}
