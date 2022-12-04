module Token where

type Content = String

data Token
  = Token TokenType Content
  deriving Show

data TokenType
  = LPAREN     --  (
  | RPAREN     --  )
  | BIND       --  =
  | LAMBDA     --  \  -- \x.x
  | DOT        --  .
  | SEMICOLON  --  ;
  | IDENT      --  identifier
  | EOF
  deriving Show

-- keywords = INCLUDE, PRINT
