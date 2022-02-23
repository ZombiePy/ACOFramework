package project.algorithm

import project.colony.BaseColony
import project.problem.BaseProblem
import project.colony.BasicColony
import project.solution.BaseSolution
import project.repo.BasicSolutionRepo
import project.pheromone.BasicPheromoneTable
import scala.util.Random
import pareto.getParetoFrontMin
import project.repo.BaseSolutionRepo

class BasicAlgorithm(
    antNumb: Int,
    val problem: BaseProblem,
    val iterations: Int
) extends BaseAlgorithm {
  val solutionRepo = new BasicSolutionRepo()

  override def run(): BaseSolutionRepo = {
    val increment = 5
    val alpha = 1.0
    val beta = 1.0
    val extinction = 0.2

    val distanceWeights =
      List.fill(problem.dimensions)(1.0 / problem.dimensions)
    val pheromoneWeights =
      List.fill(problem.dimensions)(1.0 / problem.dimensions)
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
      antNumb,
      problem,
      pheromone,
      distanceWeights,
      pheromoneWeights
    )
    for (iteration <- 0 until iterations) {
      val solutions: List[BaseSolution] = colony.run()
      colony.pheromoneUpdate(solutions)
      println(
        s"Step ${iteration}:${solutions.map(_.evaluation.zip(distanceWeights).map(_ * _).sum).min}"
      )
      solutionRepo.add_solutions(
        iteration,
        solutions.zip(getParetoFrontMin(solutions.map(_.evaluation))).collect {
          case (v, true) => v
        }
      )
      if (iteration % 10 == 9) {
        println(solutionRepo.solutions(iteration).map(_.evaluation))
      }
    }
    val z = solutionRepo.solutions.flatMap(_._2.map(_.evaluation)).toList
    println(z.zip(getParetoFrontMin(z)).collect { case (v, true) => v })
    solutionRepo
  }
}
