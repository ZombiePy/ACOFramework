package project.pheromone

import project.graph.{Edge, Node}
import project.solution.BaseSolution
import scala.collection.mutable.{Map}
class BasicPheromoneTable(
    edges: List[Edge],
    val increment: Double,
    val extinction: Double,
    val pheromoneDimension: Int
) extends BasePheromoneTable {
  val pheromone: List[Map[Edge, Double]] =
    List.fill(pheromoneDimension)(edges.map((_, 1.0)).to(Map))
  override def getPheromone(edge: Edge): List[Double] = pheromone.map(_(edge))

  override def pheromoneUpdate(solution: BaseSolution): Unit = {
    solution.solution
      .sliding(2)
      .map(x => Edge(x.head, x.last))
      .foreach(edge =>
        pheromone.foreach(matrix =>
          matrix.updateWith(edge)(value => value.map(_ + increment))
        )
      )
  }

  override def pheromoneExtinction(): Unit = {
    pheromone.foreach(_.transform((y, z) => z * (1 - extinction)))
  }

}
