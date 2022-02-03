package tsp

import project.graph.Node
import project.problem.TspProblem
import tsp.nodeCoordSectionToMatrix

sealed trait TspType
case object TSPTspType extends TspType

sealed trait EdgeWeightType
case object EUC_2D extends EdgeWeightType

case class CityName(value: String) extends AnyVal

case class Tsp(
    name: String,
    ty: TspType,
    dimension: Int,
    edgeWeightType: EdgeWeightType,
    nodeCoordSection: Map[CityName, (Double, Double)]
)

def TspToProblem(tsp: Tsp): (Map[Node, CityName], TspProblem) = {
  val citiesEnumerated = tsp.nodeCoordSection
    .map(_._1)
    .zipWithIndex
    .map((name, index) => (name, Node(index)))
    .toMap

  val mapped = tsp.nodeCoordSection.map(key_value =>
      (citiesEnumerated(key_value._1), key_value._2)
    )

  val tspProblem = TspProblem(
    nodes = mapped.keys.toList,
    matrix = nodeCoordSectionToMatrix(mapped)
  )
  (citiesEnumerated.map(_.swap).toMap, tspProblem)
}