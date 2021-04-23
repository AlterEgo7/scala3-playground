import cats.effect._
import cats.syntax.all._
import com.typesafe.scalalogging.Logger
import http.Server
import petstore.domain._
import repositories.PostgresPetRepository
import skunk._
import natchez.Trace.Implicits.noop

object Main extends IOApp {
  def run(args: List[String]): IO[ExitCode] = {
    val l = Logger("test-logger")
    l.info("Starting App")

    val session: Resource[IO, Session[IO]] = PostgresPetRepository.createSession[IO]

    session.use { s =>
      PostgresPetRepository(s).setupTables >>
      Server.stream[IO].compile.drain.as(ExitCode.Success)
    }
  }
}
