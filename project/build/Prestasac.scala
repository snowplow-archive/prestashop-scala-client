import sbt._

class PrestasacProject(info: ProjectInfo) extends DefaultProject(info)
{
  // Dependencies for this library
  val scalaj_collection = "org.scalaj" %% "scalaj-collection" % "1.1"
  val apache_http_core = "org.apache.httpcomponents" % "httpcore" % "4.1.1"
  val apache_http_client = "org.apache.httpcomponents" % "httpclient" % "4.1.1"

  // Extra resources to include in the .jar
  def extraResources = "GNU-AGPL-3.0.txt" +++ "README.markdown"
  override def mainResources = super.mainResources +++ extraResources
}
