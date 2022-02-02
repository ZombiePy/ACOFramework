package project.solution

import project.graph.Node

class BaseSolution(nodes: List[Node], value: List[Double]) {
  val solution: List[Node] = nodes
  val evaluation: List[Double] = value
}
