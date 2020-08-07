package example.impatient.`trait`

class ConsoleLogger extends Logger {
  override def log(msg: String): Unit = println(msg)
}
