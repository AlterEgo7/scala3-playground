package petstore.domain

import io.circe._
import scala.util.Try

enum PetStatus:
  case Available, Pending, Adopted

object PetStatus:
  given petStatusEncoder: Encoder[PetStatus] = Encoder.encodeString.contramap(_.toString)

  given petStatusDecoder: Decoder[PetStatus] =
    Decoder.decodeString.emapTry { (s: String) =>
      Try(PetStatus.valueOf(s))
    }