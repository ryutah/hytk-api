name := """hytk-api"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  "org.springframework" % "spring-context" % "4.0.5.RELEASE"
)

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.34"