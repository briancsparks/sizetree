import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.Files.walk

fun main(args: Array<String>) {

  var i = 0

  var numFiles = 0;
  var numDirs  = 0;
  var numBytes = 0L;

  // FileTreeWalk walk = ...
  var walk = File("/Users/sparksb/dev").walkTopDown().maxDepth(6)

    .onEnter {
      // TODO: Do not follow links, for example
//      println("Enter: ${it.absolutePath}")
      true
    }

    .onLeave {
//      println("Leave: ${it.absolutePath}")
    }

    .onFail { file, ex ->
      println("FAIL: $file (${ex.toString()})");
    }

    .forEach {
      println("Looking at: ${it.absolutePath} (${it.length()})")
      if (it.isFile) {
        numFiles += 1
        numBytes += it.length()
      } else {
        numDirs += 1
        numBytes += it.length()
      }
    }

  println("Processed ${numFiles} files, ${numDirs} for ${numBytes} bytes.")
  var j = i;

}
