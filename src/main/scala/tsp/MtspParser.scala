package tsp
import project.problem.Mtsp
import project.graph.Node
import scala.math.sqrt

def TspsToMtsp(tsps: Iterable[Tsp]):Mtsp = {
    val mapped = tsps.map(_.nodeCoordSection.map(key_value=>(CityNameToNode(key_value._1),key_value._2)))
    Mtsp(
        nodes = mapped.head.keys.toList,
        matrices = mapped.map(nodeCoordSectionToMatrix).toList
    )
}
def CityNameToNode(cityName:CityName) = Node(cityName.value)

def euclideanDistance(p1:(Double,Double),p2:(Double,Double)) = {
    sqrt((p1._1-p2._1)*(p1._1-p2._1)+(p1._2-p2._2)*(p1._2-p2._2))
}
def nodeCoordSectionToMatrix(nodeCoordSection: Map[Node, (Double, Double)]):Map[(Node,Node), Double] = {
    (for {
    c1 <- nodeCoordSection.keys
    c2 <- nodeCoordSection.keys
    if c1 != c2
    } yield {
        ((c1, c2), euclideanDistance(nodeCoordSection(c1),nodeCoordSection(c2)))
    }).toMap
}