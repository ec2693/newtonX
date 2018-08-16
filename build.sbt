name := "newtonX"

version := "2.5.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)


scalaVersion := "2.11.7"

organization := "be.objectify"

libraryDependencies += jdbc
libraryDependencies += evolutions

libraryDependencies ++= Seq(
  evolutions,
  "postgresql" % "postgresql" % "9.1-901-1.jdbc4",
  "com.google.code.gson" % "gson" % "2.6.2",
  "mysql" % "mysql-connector-java" % "8.0.12"
)

routesGenerator := InjectedRoutesGenerator
