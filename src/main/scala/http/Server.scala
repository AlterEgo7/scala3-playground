package http

import cats.effect._
import cats.Monad
import org.http4s.syntax.all._
import org.http4s.server._
import org.http4s.server.blaze.BlazeServerBuilder
import org.http4s.server.middleware.Logger
import fs2._
import scala.concurrent.ExecutionContext.global

object Server {

  def stream[F[_]: Async: Monad]: Stream[F, Nothing] = {
    val httpApp    = PetService[F].rootRoutes.orNotFound
    val withLogger = Logger.httpApp(true, true)(httpApp)

    BlazeServerBuilder[F](global)
      .bindHttp(8080, "0.0.0.0")
      .withHttpApp(withLogger)
      .serve
  }.drain

}
