package project.algorithm

import project.colony.BaseColony
import project.problem.BaseProblem
import project.colony.BasicColony
import project.solution.BaseSolution
import project.repo.BasicSolutionRepo
import project.pheromone.BasicPheromoneTable
import scala.util.Random

class BasicAlgorithm(
    ant_numb: Int,
    val problem: BaseProblem,
    val iterations: Int
) extends BaseAlgorithm {
  val solutionRepo = new BasicSolutionRepo()

  override def run(): Unit = {
    val increment = 1
    val alpha = 1.0
    val beta = 3.0
    val extinction = 0.5
    val distanceWeights = List(0.34, 0.33, 0.33)
    val pheromoneWeights = List(0.34, 0.33, 0.33)
    val pheromone = BasicPheromoneTable(
      problem.edges,
      increment,
      extinction,
      pheromoneWeights.size
    )
    val rnd = Random(1337)
    val colony = BasicColony(
      alpha,
      beta,
      rnd,
      ant_numb,
      problem,
      pheromone,
      distanceWeights,
      pheromoneWeights
    )
    for (iteration <- 0 until iterations) {
      val soutions: List[BaseSolution] = colony.run()
      // solutionRepo.add_solutions(iteration, solutions)
    }
  }
}
