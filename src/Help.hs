module Help where

slice :: [a] -> Int -> Int -> [a]
slice list start end = take (end - start + 1) (drop start list)
