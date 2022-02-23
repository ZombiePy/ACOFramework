package project.repo

import project.solution.BaseSolution
import scala.collection.mutable.Map
abstract class BaseSolutionRepo(val solutions: Map[Int, List[BaseSolution]]) {

  def add_solutions(iteration: Int, new_solutions: List[BaseSolution]): Unit
}
