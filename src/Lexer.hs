module Lexer where

import Data.Char (isLetter, isNumber)
import Data.List (isPrefixOf)

import Token
import Help

scan :: String -> [Token]
scan []     = [Token EOF "eof"]
scan c@(x:xs) = case x of
  '(' ->  Token LPAREN    "("  : scan xs
  ')' ->  Token RPAREN    ")"  : scan xs
  '=' ->  Token BIND      "="  : scan xs
  '\\' -> Token LAMBDA    "\\" : scan xs
  '.' ->  Token DOT       "."  : scan xs
  ';' ->  Token SEMICOLON ";"  : scan xs
  _ | x == ' ' || x == '\n' || x == '\t' -> scan xs
  _ | isNumber x || isLetter x ->
      let ident = scanIdent c
      in fst ident : scan (snd ident)
  _ -> error $ "unknown symbol: " ++ show x

scanIdent :: String -> (Token, String)
scanIdent x | prefix "let " =
              (Token LET     token, slice x 3 (length x))
            | prefix "in " =
              (Token IN      token, slice x 2 (length x))
            | prefix "include " =
              (Token INCLUDE token, slice x 7 (length x))
            | otherwise =
              (Token IDENT   token, xs)
              where
                token    = takeWhile isName x
                xs       = dropWhile isName x
                prefix p = isPrefixOf p x
                isName x = isLetter x || isNumber x
