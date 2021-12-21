package project.aggregator

import org.graalvm.compiler.graph.Node
import project.pheromone.BasePheromone
import project.solution.BaseSolution

abstract class BasePheromoneAggregator (list_of_pheromones: List[BasePheromone]){
  val pheromones: List[BasePheromone] = list_of_pheromones

  def evaluate(solutions: List[BaseSolution]): Map[Node, Float] = {
    /*
    Function to aggregate multiple pheromones in to single value per problem Node
     */
  }
}
