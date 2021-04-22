package petstore.domain
import io.circe._

enum PetCategory:
 case Dog, Cat

object PetCategory:
  given petCategoryEncoder(using stringEncoder: Encoder[String]): Encoder[PetCategory] with {
   final def apply(status: PetCategory): Json = stringEncoder(status.toString)
  }