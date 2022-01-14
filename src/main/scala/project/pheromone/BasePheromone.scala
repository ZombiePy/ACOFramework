package project.pheromone

import project.graph.{Edge, Node}
import project.solution.BaseSolution

abstract class BasePheromone {

  def evaluate(solutions: List[BaseSolution]): Map[Edge, Float] = {
    /*
    Function to evaluate pheromone value per egde, based on solutions
     */
    ???
  }

}
