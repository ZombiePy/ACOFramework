package project.algorithm

import project.colony.BaseColony
import project.problem.BaseProblem
import project.colony.BasicColony
import project.solution.BaseSolution
import project.repo.BasicSolutionRepo
import project.pheromone.BasePheromoneTable

class BasicAlgorithm(
    ant_numb: Int,
    val problem: BaseProblem,
    val iterations: Int
) extends BaseAlgorithm {
  val solutionRepo = new BasicSolutionRepo()

  override def run(): Unit = {
    val increment = 1
    val extinction = 0.5
    val pheromone = BasePheromoneTable(problem.edges, increment, extinction)
    val colony = BasicColony(ant_numb, problem, pheromone)
    for (iteration <- 0 until iterations) {
      val soutions: List[BaseSolution] = colony.run()
      // solutionRepo.add_solutions(iteration, solutions)
    }
  }
}
