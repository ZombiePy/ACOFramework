package project.ant

import org.graalvm.compiler.graph.Node
import project.decision.BaseDecisionAlgorithm
import project.problem.BaseProblem
import project.solution.BaseSolution

import scala.collection.mutable.ListBuffer

abstract class BaseAnt (startingNode: Node, val problem: BaseProblem, val decision: BaseDecisionAlgorithm) {
  var currentNode: Node = startingNode
  var visitedNodes: ListBuffer[Node] = ListBuffer[Node]()
  visitedNodes.append(currentNode)

  def run() = {
    /*
    Function that make decision about next move of ant
    change currentNode to chosen one and add it to visitedNodes list
     */
    ???
  }

  def evaluateSolution(): BaseSolution = {
    /*
    Prepare solution from gathered information
    needs to send information to problem to update pheromone
     */
    ???
  }

}
