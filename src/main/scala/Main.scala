import cats.effect._
import cats.syntax.all._
import com.typesafe.scalalogging.Logger
import http.Server

object Main extends IOApp {
  def run(args: List[String]): IO[ExitCode] = {
    val l = Logger("test-logger")
    l.info("Starting App")

    Server.stream[IO].compile.drain.as(ExitCode.Success)
  }
}
//
//@main def hello: Unit = {
//  println("Hello world!")
//  println(msg)
//}

def msg = "I was compiled by Scala 3. :)"

def msgF = IO("this runs in IO")
