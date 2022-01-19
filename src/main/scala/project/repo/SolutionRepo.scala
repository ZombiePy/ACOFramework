package project.repo

import project.solution.BaseSolution

abstract class SolutionRepo {
  var solutions: Map[Int, List[BaseSolution]] = Map[Int, List[BaseSolution]]()
}
