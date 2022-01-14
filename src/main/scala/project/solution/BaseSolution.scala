package project.solution

import org.graalvm.compiler.graph.Node

class BaseSolution(nodes: List[Node], value: Float) {
  val solution: List[Node] = nodes
  val evaluation: Float = value
}
