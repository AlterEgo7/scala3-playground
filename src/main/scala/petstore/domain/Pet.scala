package petstore.domain
import io.circe._

import java.util.UUID

opaque type PetName = String
object PetName:
  def apply(name: String): PetName = name

  given Encoder[PetName] = summon[Encoder[PetName]]

opaque type PetBio = String
object PetBio:
  def apply(bio: String): PetBio = bio

  given Encoder[PetBio] = summon[Encoder[PetBio]]

opaque type PetId = UUID
object PetId:
  def apply(uuid: UUID): PetId = uuid
  def generate(): PetId = UUID.randomUUID()

  given Encoder[PetId] = summon[Encoder[PetId]]

final case class Pet (
  name: PetName,
  category: PetCategory,
  bio: PetBio,
  status: PetStatus = PetStatus.Available,
  id: Option[PetId] = None
)
