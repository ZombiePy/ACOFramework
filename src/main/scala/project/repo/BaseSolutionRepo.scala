package project.repo

import project.solution.BaseSolution

abstract class BaseSolutionRepo {

  def add_solutions(iteration: Int, new_solutions: List[BaseSolution]): Unit
}
