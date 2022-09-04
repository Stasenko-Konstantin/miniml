sealed abstract class TokenType

class Token(val token: TokenType, val content: String):
  override def toString: String = "{ " + token + ", " + content + " }"

object Token:
  case object NAME extends TokenType
  case object NUM extends TokenType
  case object STRING extends TokenType
  case object LPAREN extends TokenType
  case object RPAREN extends TokenType
  case object IDENT extends TokenType
  case object EOF extends TokenType