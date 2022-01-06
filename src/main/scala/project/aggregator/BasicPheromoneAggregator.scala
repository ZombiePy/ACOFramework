package project.aggregator

import org.graalvm.compiler.graph.Edges
import project.pheromone.BasePheromone
import project.solution.BaseSolution

class BasicPheromoneAggregator (pheromones: List[BasePheromone])
  extends BasePheromoneAggregator (pheromones) {

  override def evaluate(): Map[Edges, Float] = {
    for (pheromone <- pheromones) {

    }
    ???
  }
}
