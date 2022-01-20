package project.algorithm

import project.colony.BaseColony
import project.problem.BaseProblem
import project.colony.BasicColony
import project.solution.BaseSolution
import project.repo.SolutionRepo

class BasicAlgorithm(
    ant_numb: Int,
    val problem: BaseProblem,
    val iterations: Int
) extends BaseAlgorithm {
  val colony = BasicColony(ant_numb, problem)
  val solutionRepo = new SolutionRepo()

  override def run(){
    for (iteration <- 0 until iterations) {
      val soutions: List[BaseSolution] = colony.run()
      solutionRepo.add_solutions(iteration, solutions)
    }
  }
}
