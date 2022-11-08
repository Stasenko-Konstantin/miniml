module Lexer where

import Data.Char

import Token

scan :: String -> [Token]
scan []     = [Token EOF "eof"]
scan (x:xs) = case x of
  '=' ->  Token BIND      "="  : scan xs
  '\\' -> Token LAMBDA    "\\" : scan xs
  '.' ->  Token DOT       "."  : scan xs
  ';' ->  Token SEMICOLON ";"  : scan xs
  _ | isNumber x || isLetter x ->
      let ident = scanIdent xs
      in fst ident : scan (snd ident)

scanIdent :: String -> (Token, String)
scanIdent = undefined
