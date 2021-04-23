//trait Show[T] {
//  def show: Unit
//}
//
//given Show[String] with
//  def show: Unit = println("foo")
//
//object A {
//  opaque type Foo = String
//}
//
//@main def test =
//  import A.Foo
//  summon[Show[String]]
//  summon[Show[Foo]]
