package project.pheromone

import project.graph.{Edge, Node}
import project.solution.BaseSolution
import scala.collection.mutable.{Map}
class BasicPheromoneTable(
    val edges: List[Edge],
    val increment: Double,
    val extinction: Double,
    val pheromoneDimension: Int
) extends BasePheromoneTable {
  val pheromone = Map[Edge, List[Double]]()
  def construct_pheromone(): Unit =
    edges.foreach(pheromone.update(_, List.fill(pheromoneDimension)(0)))
  construct_pheromone()

  override def getPheromone(edge: Edge): List[Double] = pheromone(edge)

  override def pheromoneUpdate(solution: BaseSolution): Unit = {
    for (nodePair <- solution.solution.sliding(2)) {
      if (nodePair.knownSize == 2) {
        val edge = new Edge(nodePair.head, nodePair.last)
        pheromone.update(edge, pheromone(edge).map(_ + increment))
      }
    }
  }

  override def pheromoneExtinction(): Unit = {
    for (edge <- edges) {
      pheromone(edge) = pheromone(edge).map(_ * (1 - extinction))
    }
  }

}
