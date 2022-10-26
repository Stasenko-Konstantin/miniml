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

main :: IO ()
main = do
  args <- getArgs
  parseArgs args

parseArgs :: [String] -> IO ()
parseArgs ["--help"] = putStrLn help
parseArgs [file] = evalFile file
parseArgs _ = runInputT defaultSettings repl

evalFile :: String -> IO ()
evalFile = undefined

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
      repl

help :: String
help = ":q \t--\t exit\n"
  ++ ":h \t--\t prints help\n"
