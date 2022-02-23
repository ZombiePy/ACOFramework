import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor
import scala.collection.JavaConverters._
import tsp.TspReader
import java.io.File
import scala.beans.BeanProperty
import java.io.FileInputStream
import tsp.TspReader
import tsp.TspsToMtsp
import tsp.TspToProblem
import tsp.Tsp
import project.algorithm.BasicAlgorithm
import project.algorithm.TspSolver
import project.algorithm.BaseAlgorithm
import pareto.getParetoFrontMin
object Main {
  def main(args: Array[String]): Unit = {
    println(System.getProperty("user.dir"))
    val filename = "src//main//config.yaml"
    val input = new FileInputStream(new File(filename))
    val yaml = new Yaml(new Constructor(classOf[ProblemConfig]))
    val ants_number = 100
    val algorithm_iterations = 100
    val e = yaml.load(input).asInstanceOf[ProblemConfig]
    e.problemType match {
      case "tsp" => {
        val tsp = TspReader.read(
          new File(
            "src//main//resources//" ++ asScalaBuffer(e.problemFiles).head
          )
        )
        val (reverseNameMap, tspProblem) = TspToProblem(tsp)
        val algo = TspSolver(ants_number, tspProblem, algorithm_iterations)
        algo.run()
      }
      case "mtsp" => {
        val tsps = for {
          file <- asScalaBuffer(e.problemFiles)
        } yield {
          TspReader.read(new File("src//main//resources//" ++ file))
        }
        val (reverseNameMap, mtspProblem) = TspsToMtsp(tsps)
        val algo =
          BasicAlgorithm(ants_number, mtspProblem, algorithm_iterations)
        algo.run()
      }
      case _ =>
        throw NotImplementedError(
          "Your method from config.yaml is not implemented!"
        )
    }

  }
}
class ProblemConfig {
  @BeanProperty var problemType: String = null
  @BeanProperty var problemFiles = new java.util.ArrayList[String]()
  override def toString: String = {
    return String.join(",", problemFiles)
  }
}
