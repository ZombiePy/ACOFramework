package project.aggregator

import org.graalvm.compiler.graph.{Edges, Node}
import project.pheromone.BasePheromone
import project.solution.BaseSolution

abstract class BasePheromoneAggregator (val pheromones: List[BasePheromone]){

  def evaluate(): Map[Edges, Float] = {
    /*
    Function to aggregate multiple pheromones in to single value per problem Egde
     */
    ???
  }

}
