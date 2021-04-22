val scala3Version = "3.0.0-RC2"

lazy val root = project
  .in(file("."))
  .settings(
    name := "scala3-playground",
    version := "0.1.0",
    fork := true,
    scalaVersion := scala3Version,
    libraryDependencies ++= Seq(
      "org.typelevel"              %% "cats-effect"         % "3.1.0",
      "org.http4s"                 %% "http4s-core"         % "1.0.0-M21",
      "org.http4s"                 %% "http4s-dsl"          % "1.0.0-M21",
      "org.http4s"                 %% "http4s-blaze-server" % "1.0.0-M21",
      "org.http4s"                 %% "http4s-circe"        % "1.0.0-M21",
      "io.circe"                   %% "circe-generic"       % "0.14.0-M5",
      "ch.qos.logback"              % "logback-classic"     % "1.2.3",
      "com.typesafe.scala-logging" %% "scala-logging"       % "0.0.0+1-2c238c93-SNAPSHOT",
      "org.typelevel"              %% "munit-cats-effect-3" % "1.0.1" % Test
//      "org.scalameta" %% "munit"       % "0.7.25" % Test
    )
  )
