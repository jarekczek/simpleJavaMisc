import java.net.InetSocketAddress
import java.net.ServerSocket

class SocketServer {

}

fun main(args: Array<String>) {
  println("heelo")
  val socket = ServerSocket(12000)
  while (true) {
    val socket = socket.accept()!!
    println("new connection from " + socket.port)
    InputStreamPrinter(socket.getInputStream())
  }
  val ch = socket.accept()
  val istr = ch.getInputStream()
  while (true) {
    val c = istr.read()
    if (c < 0)
      break
    print(c.toChar())
  }
}
