import org.yaml.snakeyaml.Yaml
import org.yaml.snakeyaml.constructor.Constructor
import scala.collection.JavaConverters._
import tsp.TspReader
import java.io.File
import scala.beans.BeanProperty
import java.io.FileInputStream
import tsp.TspReader
import tsp.TspsToMtsp

object Main {
  def main(args: Array[String]): Unit = {
    val filename = "src\\main\\config.yaml"
    val input = new FileInputStream(new File(filename))
    val yaml = new Yaml(new Constructor(classOf[ProblemConfig]))
    val e = yaml.load(input).asInstanceOf[ProblemConfig]
    val tsps = for {
      file <- asScalaBuffer(e.problem)
    } yield {
      TspReader.read(new File("src\\main\\resources\\" ++ file))
    }
    val mtsp = TspsToMtsp(tsps)
  }
}
class ProblemConfig {
  @BeanProperty var problem = new java.util.ArrayList[String]()
  override def toString: String = {
    return String.join(",", problem)
  }
}
