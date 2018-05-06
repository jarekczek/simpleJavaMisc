import org.apache.logging.log4j.LogManager

fun main(args: Array<String>) {
  IntRange(1, 10).forEach {
    LogManager.getLogger("x").info("message $it")
  }
}