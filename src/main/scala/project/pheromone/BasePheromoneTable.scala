package project.pheromone

import project.graph.{Edge, Node}
import project.solution.BaseSolution
import scala.collection.mutable.{Map}
class BasePheromoneTable(
    val edges: List[Edge],
    val increment: Double,
    val extinction: Double
) {
  val pheromone = Map[Edge, List[Double]]()
  def construct_pheromone(): Unit = edges.foreach(pheromone.update(_, 0))
  construct_pheromone()

  def getPheromone(edge: Edge): List[Double] = pheromone(edge)

  def pheromoneUpdate(solution: BaseSolution): Unit = {
    for (nodePair <- solution.solution.sliding(2)) {
      if (nodePair.knownSize == 2) {
        val edge = new Edge(nodePair.head, nodePair.last)
        pheromone.update(edge, pheromone(edge) + increment)
      }
    }
  }

  def pheromoneExtinction(): Unit = {
    for (edge <- edges) {
      pheromone(edge) = pheromone(edge) * (1 - extinction)
    }
  }

}
