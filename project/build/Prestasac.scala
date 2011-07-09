import sbt._

class PrestasacProject(info: ProjectInfo) extends DefaultProject(info)
{
  val scalaj_collection = "org.scalaj" %% "scalaj-collection" % "1.1"
  val apache_http_core = "org.apache.httpcomponents" % "httpcore" % "4.1.1"
  val apache_http_client = "org.apache.httpcomponents" % "httpclient" % "4.1.1"
}
