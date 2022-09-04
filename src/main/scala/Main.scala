import scala.annotation.tailrec
import scala.io.StdIn.readLine

@main
def main(): Unit = repl

@tailrec
def repl: Unit =
  print("\t")
  val input = readLine() + "\n"
  if input == ":q" || input == ":quit" then
    System.exit(1)
  val tokens = Lexer.scan(input)
  println(tokens)
  repl