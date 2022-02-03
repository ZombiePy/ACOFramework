package tsp
import project.problem.Mtsp
import project.graph.Node
import scala.math.sqrt
import project.graph.Edge

def TspsToMtsp(tsps: Iterable[Tsp]): (Map[Node, CityName], Mtsp) = {
  val citiesEnumerated = tsps.head.nodeCoordSection
    .map(_._1)
    .zipWithIndex
    .map((name, index) => (name, Node(index)))
    .toMap
  val mapped = tsps.map(
    _.nodeCoordSection.map(key_value =>
      (citiesEnumerated(key_value._1), key_value._2)
    )
  )
  val mtsp = Mtsp(
    nodes = mapped.head.keys.toList,
    matrices = mapped.map(nodeCoordSectionToMatrix).toList
  )
  (citiesEnumerated.map(_.swap).toMap, mtsp)
}

def euclideanDistance(p1: (Double, Double), p2: (Double, Double)) = {
  sqrt((p1._1 - p2._1) * (p1._1 - p2._1) + (p1._2 - p2._2) * (p1._2 - p2._2))
}
def nodeCoordSectionToMatrix(
    nodeCoordSection: Map[Node, (Double, Double)]
): Map[Edge, Double] = {
  (for {
    c1 <- nodeCoordSection.keys
    c2 <- nodeCoordSection.keys
    if c1 != c2
  } yield {
    (
      Edge(c1, c2),
      euclideanDistance(nodeCoordSection(c1), nodeCoordSection(c2))
    )
  }).toMap
}
