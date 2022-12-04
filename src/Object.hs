module Object where

import           Token

data Object a b
  = Object [Token] ObjectType (a -> b)

instance Show (Object a b) where
  show (Object tokens oType _) = show oType ++ ": " ++ (show tokens)

data ObjectType = NAME | LAMBDA deriving Show

data Program = [Object]
