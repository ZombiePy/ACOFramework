package project.problem

import org.graalvm.compiler.graph.Edges
import org.graalvm.compiler.graph.Node
import project.aggregator.BasePheromoneAggregator

abstract class BaseProblem (list_of_nodes: List[Node],
                            list_of_edges: Edges,
                            aggregator: BasePheromoneAggregator) {
  val nodes: List[Node] = list_of_nodes
  val edges: Edges = list_of_edges
  var pheromones: Map[Node, Float] = Map()
  val pheromone_aggregator : BasePheromoneAggregator = aggregator

  def evaluate(solution: List[Node]): None = {
    /*
    Function to evaluate solution in to single float
     */
  }

  def pheromoneUpdate(): None = {
    /*
    Function to update pheromone after run based on solution repository
     */
  }

}
