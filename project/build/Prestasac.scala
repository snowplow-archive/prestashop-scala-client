import sbt._

class PrestasacProject(info: ProjectInfo) extends DefaultProject(info)
{
  // Dependencies for this library
  val scalajCollection = "org.scalaj" %% "scalaj-collection" % "1.1"
  val httpcore = "org.apache.httpcomponents" % "httpcore" % "4.1.1"
  val httpcomponentsClient = "org.apache.httpcomponents" % "httpclient" % "4.1.1"
  val mavenArtifact = "org.apache.maven" % "maven-artifact" % "3.0.3"

  // Extra resources to include in the .jar
  def extraResources = "GNU-AGPL-3.0.txt" +++ "README.markdown"
  override def mainResources = super.mainResources +++ extraResources
}
