package petstore.domain
import io.circe._

import java.util.UUID

opaque type PetName = String
object PetName:
  def apply(name: String): PetName = name

  given petNameEncoder(using stringEncoder: Encoder[String]): Encoder[PetName] with {
    final def apply(name: PetName): Json = stringEncoder(name)
  }

opaque type PetBio = String
object PetBio:
  def apply(bio: String): PetBio = bio

  given petBioEncoder(using stringEncoder: Encoder[String]): Encoder[PetBio] with {
    final def apply(bio: PetBio): Json = stringEncoder(bio)
  }

opaque type PetId = UUID
object PetId:
  def apply(uuid: UUID): PetId = uuid
  def generate(): PetId = UUID.randomUUID()

  given petIdEncoder(using uuidEncoder: Encoder[UUID]): Encoder[PetId] with {
    final def apply(id: PetId): Json = uuidEncoder(id)
  }

final case class Pet (
  name: PetName,
  category: PetCategory,
  bio: PetBio,
  status: PetStatus = PetStatus.Available,
  id: Option[PetId] = None
)
