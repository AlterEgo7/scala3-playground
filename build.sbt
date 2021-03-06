val scala3Version = "3.0.0"

lazy val root = project
  .in(file("."))
  .settings(
    name := "scala3-playground",
    version := "0.1.0",
    fork := true,
    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(
      "org.typelevel"              %% "cats-effect"         % "3.1.1",
      "org.http4s"                 %% "http4s-core"         % "1.0.0-M23",
      "org.http4s"                 %% "http4s-dsl"          % "1.0.0-M23",
      "org.http4s"                 %% "http4s-blaze-server" % "1.0.0-M23",
      "org.http4s"                 %% "http4s-circe"        % "1.0.0-M23",
      "io.circe"                   %% "circe-generic"       % "0.14.1",
      "ch.qos.logback"              % "logback-classic"     % "1.2.3",
      "org.tpolecat"               %% "skunk-core"          % "0.2.0",
      "org.tpolecat"               %% "skunk-circe"         % "0.2.0",
      "org.tpolecat"               %% "natchez-core"        % "0.1.5",
      "com.typesafe.scala-logging" %% "scala-logging"       % "3.9.4",
      "org.typelevel"              %% "munit-cats-effect-3" % "1.0.5" % Test
//      "org.scalameta" %% "munit"       % "0.7.25" % Test
    )
  )
