package project.pheromone

import org.graalvm.compiler.graph.Node
import project.solution.BaseSolution

abstract class BasePheromone {

  def evaluate(solutions: List[BaseSolution]): Map[Node, Float] = {
    /*
    Function to evaluate pheromone value per node, based on solutions
     */
  }

}
