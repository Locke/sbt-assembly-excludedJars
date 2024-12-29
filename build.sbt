
ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := Dependencies.scalaVersion

ThisBuild / packageTimestamp := Package.gitCommitDateTimestamp

Compile / mainClass := Some("com.example.Hello")

ThisBuild / libraryDependencies ++= Dependencies.exampleDependencies

assembly / assemblyExcludedJars := (assembly / fullClasspath).value.filter(_.data.getName.startsWith("javafx-"))
