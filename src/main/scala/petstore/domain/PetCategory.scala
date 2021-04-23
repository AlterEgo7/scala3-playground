package petstore.domain
import io.circe._

import scala.util.Try

enum PetCategory:
 case Dog, Cat

object PetCategory:

  given petCategoryEncoder: Encoder[PetCategory] = Encoder.encodeString.contramap(_.toString)

  given petCategoryDecoder: Decoder[PetCategory] =
    Decoder.decodeString.emapTry { (s: String) =>
      Try(PetCategory.valueOf(s))
    }
