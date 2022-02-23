package project.algorithm

import project.colony.BaseColony
import project.problem.BaseProblem
import project.repo.BaseSolutionRepo

abstract class BaseAlgorithm {
  val problem: BaseProblem
  def run(): BaseSolutionRepo
}
