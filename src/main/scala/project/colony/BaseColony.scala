package project.colony

import project.aggregator.BasicPheromoneAggregator
import project.ant.BaseAnt
import project.pheromone.BasePheromoneTable
import project.problem.BaseProblem
import project.solution.BaseSolution

abstract class BaseColony(
    ant_numb: Int,
    problem: BaseProblem,
    val pheromoneTable: BasePheromoneTable
) {
  var ants: List[BaseAnt] = createAnts()
  // val pheromoneAggregator = new BasicPheromoneAggregator()
  /** Function that runs all ants to create solutions
    */
  def run(): List[BaseSolution]

  /** Function to place ants
    */
  def createAnts(): List[BaseAnt]
}
