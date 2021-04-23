package http

import cats.effect._
import cats.syntax.all._
import org.http4s._
import org.http4s.server._
import org.http4s.syntax.all._
import org.http4s.dsl.Http4sDsl
import org.http4s.circe._
import org.http4s.circe.CirceEntityEncoder._
import petstore.domain._
import io.circe._
import io.circe.generic.auto._
import io.circe.syntax._

class PetService[F[_]: Async] extends Http4sDsl[F] {

  def routes: HttpRoutes[F]     =
    Router[F]("" -> rootRoutes)

  val rootRoutes: HttpRoutes[F] = HttpRoutes.of[F] {
    case GET -> Root =>
      Ok("Hello World")

    case GET -> Root / "pets" =>
      val pet = Pet(PetName("Lulu"), PetCategory.Dog, PetBio("The nicest dog"), PetStatus.Adopted, None)
      Ok(List(pet))
  }
}

object PetService {
  def apply[F[_]: Async]: PetService[F] = new PetService
}
