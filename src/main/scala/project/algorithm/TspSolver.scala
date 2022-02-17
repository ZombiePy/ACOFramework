package project.algorithm

import project.colony.BaseColony
import project.problem.BaseProblem
import project.colony.BasicColony
import project.solution.BaseSolution
import project.repo.BasicSolutionRepo
import project.pheromone.BasicPheromoneTable
import scala.util.Random

class TspSolver(
    antNumb: Int,
    val problem: BaseProblem,
    val iterations: Int
) extends BaseAlgorithm {
  val solutionRepo = new BasicSolutionRepo()

  override def run(): Unit = {
    val increment = 5
    val alpha = 1
    val beta = 1
    val extinction = 0.2
    val distanceWeights = List(1.0)
    val pheromoneWeights = List(1.0)
    val takenAntsToPheromoneUpdate = 30
    val pheromone = BasicPheromoneTable(
      problem.edges,
      increment,
      extinction,
      pheromoneWeights.size
    )
    val rnd = Random(1637)
    val colony = BasicColony(
      alpha,
      beta,
      rnd,
      antNumb,
      problem,
      pheromone,
      distanceWeights,
      pheromoneWeights
    )
    for (iteration <- 0 until iterations) {
      val soutions: List[BaseSolution] = colony.run()
//      println(s"Step ${iteration}")

      println(
        soutions.map(_.evaluation.zip(distanceWeights).map(_ * _).sum).min + ','
      )
      solutionRepo.add_solutions(iteration, soutions)
      colony.pheromoneUpdate(soutions
        .sortBy(_.evaluation.sum)
        .take(takenAntsToPheromoneUpdate))
    }
    println(solutionRepo)
  }
}


