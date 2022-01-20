package project.repo

import project.solution.BaseSolution

abstract class SolutionRepo {
  var solutions: Map[Int, List[BaseSolution]] = Map[Int, List[BaseSolution]]()

  def add_solutions(iteration: Int, new_solutions: List[BaseSolution]) = {
    solutions + (iteration -> new_solutions)
  }
}
