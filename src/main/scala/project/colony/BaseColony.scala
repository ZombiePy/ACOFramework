package project.colony

import project.ant.BaseAnt
import project.pheromone.BasePheromoneTable
import project.problem.BaseProblem

abstract class BaseColony (ant_numb: Int,
                           problem: BaseProblem) {
  var ants: List[BaseAnt] = createAnts()
  val pheromoneTable = new BasePheromoneTable(problem.edges)

  def run() = {
    /*
    Function that runs all ants to create solutions
     */
  }

  def createAnts(): List[BaseAnt] = {
    /*
    Function to place ants
     */
    ???
  }
}
