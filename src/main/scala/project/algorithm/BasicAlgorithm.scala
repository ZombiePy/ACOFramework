package project.algorithm

import project.colony.BaseColony
import project.problem.BaseProblem
import project.colony.BasicColony

class BasicAlgorithm(
    ant_numb: Int,
    val problem: BaseProblem
) extends BaseAlgorithm {
  val colony = BasicColony(ant_numb, problem)
}
