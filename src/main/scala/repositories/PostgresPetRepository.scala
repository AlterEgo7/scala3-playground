package repositories

import cats._
import cats.effect._
import cats.syntax.all._
import petstore.domain._
import skunk._
import fs2._
import skunk._
import skunk.data.Completion
import skunk.codec.all._
import skunk.implicits._
import natchez.Trace.Implicits.noop
import fs2.io.net.Network
import cats.effect.std.Console

class PostgresPetRepository[F[_]](s: Session[F]) extends PetRepositoryAlgebra[F] {
  override def create(pet: Pet): F[Pet] = ???

  override def update(pet: Pet): F[Option[Pet]] = ???

  override def get(id: PetId): F[Option[Pet]] = ???

  override def delete(id: PetId): F[Option[Pet]] = ???

  override def list: Stream[F, Pet] = ???

  override def setupTables: F[Completion] = {
    val setup: Command[Void] = sql"""
      CREATE TABLE IF NOT EXISTS pets (
        id UUID PRIMARY KEY,
        name VARCHAR NOT NULL,
        category VARCHAR NOT NULL,
        bio VARCHAR NOT NULL,
        status VARCHAR NOT NULL
      )
    """.command
    s.execute(setup)
  }
}

object PostgresPetRepository {
  def createSession[F[_]: Concurrent: Network: Console]: Resource[F, Session[F]] =
    Session.single[F](
      host = "localhost",
      user = "postgres",
      database = "pets",
      password = None
    )

  def apply[F[_]](s: Session[F]): PostgresPetRepository[F] = new PostgresPetRepository(s)
}
