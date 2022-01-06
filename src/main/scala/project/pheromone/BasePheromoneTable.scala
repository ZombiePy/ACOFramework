package project.pheromone

import org.graalvm.compiler.graph.{Edges, Node}

class BasePheromoneTable (val edges: List[Edges]) {
  val pheromone = Map[Edges, Int]()
  def construct_pheromone(): Unit = {
    for (edge <- edges) pheromone + (edge -> 0)
  }
  construct_pheromone()

  def getPheromone(edge: Edges): Float = {
    return pheromone(edge)
  }

}
