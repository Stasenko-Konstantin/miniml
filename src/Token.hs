module Token where

type Content = String

data Token
  = Token TokenType Content
  deriving Show

data TokenType
  = LET | IN | INCLUDE
  --  ^ keywords
  | BIND       --  =
  | LAMBDA     --  \  -- \x.x
  | DOT        --  .
  | SEMICOLON  --  ;
  | IDENT      --  identifier
  | EOF
  deriving Show
