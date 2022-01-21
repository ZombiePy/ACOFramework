package project.pheromone

import project.graph.{Edge, Node}
import project.solution.BaseSolution

class BasePheromoneTable(val edges: List[Edge], val increment: Double, val extinction: Float) {
  val pheromone = Map[Edge, Double]()
  def construct_pheromone(): Unit = {
    for (edge <- edges) pheromone + (edge -> 0)
  }
  construct_pheromone()

  def getPheromone(edge: Edge): Double = {
    return pheromone(edge)
  }

  def pheromoneUpdate(solution: BaseSolution) {
    for (nodePair <- solution.solution.sliding(2)){
      if (nodePair.konwnSize == 2){
          val edge = new Edge(nodePair.head, nodePair.tail)
          pheromone(edge) = pheromone(edge) + increment
      }
    }
  }

  def pheromoneExtinction() {
    for (edge <- edges) {
      pheromone(edge) = pheromone(edge) * (1 - extinction)
    }
  }

}
