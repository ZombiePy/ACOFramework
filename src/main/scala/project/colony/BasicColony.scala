package project.colony

import project.graph.{Edge, Node}
import project.ant.{BaseAnt, BasicAnt}
import project.decision.BasicDecisionAlgorithm
import project.problem.BaseProblem
import project.solution.BaseSolution

import scala.collection.mutable.ListBuffer
import scala.util.Random
import project.pheromone.BasePheromoneTable

class BasicColony(
    alpha: Double,
    beta: Double,
    random: Random,
    ant_numb: Int,
    problem: BaseProblem,
    pheromoneTable: BasePheromoneTable,
    distanceWeights: List[Double],
    pheromoneWeights: List[Double]
) extends BaseColony(ant_numb, problem, pheromoneTable) {

  override def createAnts(): List[BaseAnt] = {
    val ants = ListBuffer[BaseAnt]()
    val startingNode = problem.nodes.head

    for (_ <- 0 until ant_numb) {
      ants.append(
        new BasicAnt(
          startingNode = startingNode,
          problem = problem,
          decision = new BasicDecisionAlgorithm(
            alpha,
            beta,
            problem,
            pheromoneTable,
            random
          ),
          distanceWeights = distanceWeights,
          pheromoneWeights = pheromoneWeights
        )
      )
    }
    return ants.toList
  }

  override def run() = {
    val solutions = ListBuffer[BaseSolution]()
    for (ant <- ants) {
      val solution: BaseSolution = ant.run()
      solutions.append(solution)
    }
    solutions.toList
  }

  def pheromoneUpdate(solutions: List[BaseSolution]) = {
    solutions.foreach(pheromoneTable.pheromoneUpdate)
    pheromoneTable.pheromoneExtinction()
  }
}
