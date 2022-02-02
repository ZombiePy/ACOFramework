package project.repo

import project.solution.BaseSolution

class BasicSolutionRepo extends BaseSolutionRepo {
  var solutions: Map[Int, List[BaseSolution]] = Map[Int, List[BaseSolution]]()

  override def add_solutions(
      iteration: Int,
      new_solutions: List[BaseSolution]
  ) = {
    solutions + (iteration -> new_solutions)
  }
}
