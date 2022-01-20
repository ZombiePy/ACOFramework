package project.pheromone

import project.graph.{Edge, Node}
import project.solution.BaseSolution

class BasePheromoneTable(val edges: List[Edge]) {
  val pheromone = Map[Edge, Int]()
  def construct_pheromone(): Unit = {
    for (edge <- edges) pheromone + (edge -> 0)
  }
  construct_pheromone()

  def getPheromone(edge: Edge): Float = {
    return pheromone(edge)
  }

  def pheromoneUpdate(solution: BaseSolution) {
    for (nodePair <- solution.solution.sliding(2)){
      ???
    }
  }

}
