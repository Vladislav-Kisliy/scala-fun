package example

object FileMatcher {
  private def filesHere = (new java.io.File(".")).listFiles

  def fileMatching(matcher: (String) => Boolean) =
    for (file <- filesHere; if matcher(file.getName))
      yield file

  def filesEnding(query: String) =
    fileMatching(_.endsWith(query))

  def filesContaining(query: String) =
    fileMatching((fileName) => fileName.contains(query))

  def filesRegex(query: String) =
    fileMatching(_.matches(query))

}
