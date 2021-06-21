class MainTest extends munit.FunSuite {

  test("msg test") {
    val msg = "I was compiled by Scala 3. :)"
    assertEquals(msg, "I was compiled by Scala 3. :)")
  }
}
