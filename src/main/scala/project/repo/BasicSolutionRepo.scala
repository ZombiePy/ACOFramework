package project.repo

import project.solution.BaseSolution
import scala.collection.mutable.Map
class BasicSolutionRepo
    extends BaseSolutionRepo(Map[Int, List[BaseSolution]]()) {

  override def add_solutions(
      iteration: Int,
      new_solutions: List[BaseSolution]
  ) = solutions.update(iteration, new_solutions)

  override def toString: String = {
    var string = ""
    for (key <- solutions.keysIterator) {
      string = string.concat("Iteration: \n" + key.toString + "\n")
      val bestSolution = solutions(key)
        .sortBy(_.evaluation.sum)
        .head
      string = string.concat(
        "Best Solution: \n" + bestSolution.solution.toString + "\n"
      )
      string = string.concat(
        "Evaluation: \n" + bestSolution.evaluation.toString + "\n"
      )
    }
    string
  }
}
