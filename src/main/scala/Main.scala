import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor
import scala.collection.JavaConverters._
import tsp.TspReader
import java.io.File
import scala.beans.BeanProperty
import java.io.FileInputStream
import tsp.TspReader
import tsp.TspsToMtsp
import project.algorithm.BasicAlgorithm

object Main {
  def main(args: Array[String]): Unit = {
    println(System.getProperty("user.dir"))
    val filename = "src//main//config.yaml"
    val input = new FileInputStream(new File(filename))
    val yaml = new Yaml(new Constructor(classOf[ProblemConfig]))
    val e = yaml.load(input).asInstanceOf[ProblemConfig]
    val tsps = for {
      file <- asScalaBuffer(e.problem)
    } yield {
      TspReader.read(new File("src//main//resources//" ++ file))
    }
    val (reverseNameMap, mtsp) = TspsToMtsp(tsps)
    val ants_number = 100
    val algorithm_iterations = 10
    val algo = BasicAlgorithm(ants_number, mtsp, algorithm_iterations)
    algo.run()
  }
}
class ProblemConfig {
  @BeanProperty var problem = new java.util.ArrayList[String]()
  override def toString: String = {
    return String.join(",", problem)
  }
}
