import sbt._
import Keys._

object SpringerBuild extends Build {
  val opts = Project.defaultSettings ++ Seq(
    scalaVersion := "2.10.2",
    resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
    libraryDependencies ++= Seq(
      "org.specs2" %% "specs2" % "2.3.6" % "test"
    )
  )

  lazy val root =
    Project(id = "springer",
      base = file("."),
      settings = opts) 
}

