package project.pheromone

import org.graalvm.compiler.graph.{Edges, Node}
import project.solution.BaseSolution

abstract class BasePheromone {

  def evaluate(solutions: List[BaseSolution]): Map[Edges, Float] = {
    /*
    Function to evaluate pheromone value per egde, based on solutions
     */
    ???
  }

}
