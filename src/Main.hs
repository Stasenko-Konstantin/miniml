module Main where

import System.Environment
import System.IO
import Control.Monad.IO.Class
import System.Console.Haskeline
  ( InputT
  , defaultSettings
  , getInputLine
  , runInputT
  )

import Lexer (scan)

main :: IO ()
main = getArgs >>= parseArgs

parseArgs :: [String] -> IO ()
parseArgs ["--help"] = putStrLn help
parseArgs [file] = eval file
parseArgs _ = runInputT defaultSettings repl

repl :: InputT IO ()
repl = do
  return $ putStr "- "
  line <- getInputLine "- "
  line <- case line of
    Nothing -> return ""
    Just l -> return l :: InputT IO String
  case line of
    ":q" -> return ()
    ":h" -> (liftIO $ putStr help :: InputT IO ()) >> repl
    _ -> do
      liftIO $ eval line :: InputT IO ()
      repl

eval :: String -> IO ()
eval code = putStrLn $ show $ Lexer.scan code

help :: String
help = ":q \t--\t exit\n"
  ++ ":h \t--\t prints help"
