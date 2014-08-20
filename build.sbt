name := "Moulinette"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "javax.xml.bind" % "jaxb-api" % "2.2.11",
  "kxml" % "kxml" % "2.2.2"
)     

play.Project.playJavaSettings
