package project.colony

import project.graph.{Edge, Node}
import project.ant.{BaseAnt, BasicAnt}
import project.decision.BasicDecisionAlgorithm
import project.problem.BaseProblem
import project.solution.BaseSolution

import scala.collection.mutable.ListBuffer
import scala.util.Random

class BasicColony(ant_numb: Int, problem: BaseProblem)
    extends BaseColony(ant_numb, problem) {

  override def createAnts(): List[BaseAnt] = {
    val ants = ListBuffer[BaseAnt]()
    val startingNode = problem.nodes.head
    for (_ <- 0 until ant_numb) {
      ants.append(
        new BasicAnt(
          startingNode = startingNode,
          problem = problem,
          decision = new BasicDecisionAlgorithm(problem, pheromoneTable)
        )
      )
    }
    return ants.toList
  }
  override def run() = {
    var solutions: List[BaseSolutions] = List[BaseSolution]()
    for (ant <- ants) = {
      val solution: BaseSolution = ant.run()
      solutions :+ solution
    }
  }
}
