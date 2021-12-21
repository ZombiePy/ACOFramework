package project.solution

import org.graalvm.compiler.graph.Node

abstract class BaseSolution(nodes: List[Node], value: Float) {
  val solution: List[Node] = nodes
  val evaluation: Float = value
}
