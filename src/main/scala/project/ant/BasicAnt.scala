package project.ant

import org.graalvm.compiler.graph.{Edges, Node}
import project.decision.BaseDecisionAlgorithm
import project.problem.BaseProblem
import project.solution.BaseSolution

import scala.util.control.Breaks.{break, breakable}

class BasicAnt (startingNode: Node,
                problem: BaseProblem,
                decision: BaseDecisionAlgorithm)
  extends BaseAnt (
    startingNode,
    problem,
    decision
  ){

  override run() = {
    breakable { while (true) {
      val possibleMoves = problem.getPossibleMoves(currentNode, visitedNodes.toList)
      if (possibleMoves == None) {
        evaluateSolution()
        break
      }
      val nextMove: Edges = decision.decide(possibleMoves)
      currentNode = step(nextMove)
      visitedNodes.append(currentNode)
    }}
  }: Unit

  def step(nextMove: Edges)= {
    ???
  }: Node

  override evaluateSolution() = {
    val solution = new BaseSolution(visitedNodes.toList, problem.evaluate(visitedNodes.toList))
    return solution
  }
}
