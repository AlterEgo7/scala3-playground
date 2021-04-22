package petstore.domain
import io.circe._

enum PetStatus:
  case Available, Pending, Adopted

object PetStatus:
  given petStatusEncoder(using stringEncoder: Encoder[String]): Encoder[PetStatus] with {
    final def apply(status: PetStatus): Json = stringEncoder(status.toString)
  }
