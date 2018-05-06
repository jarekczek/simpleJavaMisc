import java.io.InputStream
import java.nio.channels.SocketChannel

class InputStreamPrinter(val istr: InputStream) : Runnable {
  override fun run() {
    val reader = istr.bufferedReader()
    while (true) {
      val line = reader.readLine()
      if (line == null) {
        println("stream closed")
        break
      }
      println(line)
    }
  }

  init {
    val th = Thread(this)
    th.start()
  }
}