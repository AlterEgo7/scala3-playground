package petstore.domain

import fs2.Stream
import skunk.data.Completion

trait PetRepositoryAlgebra[F[_]] {

  def setupTables: F[Completion]

  def create(pet: Pet): F[Pet]

  def update(pet: Pet): F[Option[Pet]]

  def get(id: PetId): F[Option[Pet]]

  def delete(id: PetId): F[Option[Pet]]

  def list: Stream[F, Pet]
}