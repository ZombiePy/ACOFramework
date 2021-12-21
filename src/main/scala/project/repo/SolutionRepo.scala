package project.repo

import project.solution.BaseSolution

abstract class SolutionRepo {
  var solutions: Map[List[BaseSolution], Int] = Map()
}
