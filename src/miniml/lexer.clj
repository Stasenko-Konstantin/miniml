(ns miniml.lexer
  (:require
    [miniml.help :as help]
    [miniml.token :as token]))

(defn scan
  [string]
  (let [t (token/new :eof " ")]
    (println (token/to-str t)))
  (help/return string))