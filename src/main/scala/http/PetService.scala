package http

import cats.effect._
import cats.syntax.all._
import org.http4s._
import org.http4s.server._
import org.http4s.syntax.all._
import org.http4s.dsl.Http4sDsl

class PetService[F[_]: Async] extends Http4sDsl[F] {

  def routes: HttpRoutes[F]     =
    Router[F]("" -> rootRoutes)

  val rootRoutes: HttpRoutes[F] = HttpRoutes.of[F] { case GET -> Root =>
    Ok("Hello World")
  }
}

object PetService {
  def apply[F[_]: Async]: PetService[F] = new PetService
}
