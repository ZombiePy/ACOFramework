package project.colony

import project.graph.{Edge, Node}
import project.ant.{BaseAnt, BasicAnt}
import project.decision.BasicDecisionAlgorithm
import project.problem.BaseProblem

import scala.collection.mutable.ListBuffer
import scala.util.Random

class BasicColony(ant_numb: Int, problem: BaseProblem)
    extends BaseColony(ant_numb, problem) {

  override def createAnts(): List[BaseAnt] = {
    val ants = ListBuffer[BaseAnt]()
    for (_ <- 0 until ant_numb) {
      ants.append(
        new BasicAnt(
          startingNode = getRandomNode(problem.nodes),
          problem = problem,
          decision = new BasicDecisionAlgorithm(problem)
        )
      )
    }
    return ants.toList
  }

  def getRandomNode(list: List[Node]): Node = {
    val random = new Random
    return list(random.nextInt(list.length))
  }
}
