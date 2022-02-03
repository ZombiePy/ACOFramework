package project.graph

case class Edge(node1: Node, node2: Node) {
  override def equals(o: Any) = o match {
    case that: Edge =>
      that.node1 == node1 && that.node2 == node2 || that.node1 == node2 && that.node2 == node1
    case _ => false
  }

  /** Cantor pairing function for optimized access of hash functions
    */
  override def hashCode =
    1 / 2 * (node1.number + node2.number) * (node1.number + node2.number + 1) + node2.number
}
