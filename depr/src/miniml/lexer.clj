(ns miniml.lexer
  (:require
    [miniml.help :as help]
    [miniml.token :as token]))

(defn scan
  [string]
  ;((let [t (token/->Token (token/TokenType :eof) "")]
  ;  (println t)))
  (help/return string))