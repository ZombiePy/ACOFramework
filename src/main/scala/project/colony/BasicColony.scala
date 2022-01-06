package project.colony

import org.graalvm.compiler.graph.Node
import project.ant.BasicAnt
import project.problem.BaseProblem

import scala.util.Random

class BasicColony (val ant_numb: Int,
                   val problem: BaseProblem
  ) extends BaseColony (ant_numb) {

  override createAnts() = {
    val ants = List()
    for (iter <- 0 until  ant_numb) ants + new BasicAnt(
      startingNode = getRandomNode(problem.nodes),
      problem = problem,
      decision = new BasicDecisionAlgorithm(
        problem = problem
      )
    )
  }

  def getRandomNode(list: List[Node]): Node = {
    val random = new Random
    return list(random.nextInt(list.length))
  }
}
