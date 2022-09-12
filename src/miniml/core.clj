(ns miniml.core
  "simple ML interpreter"
  (:require
    [miniml.help :as help]
    [miniml.lexer :as lexer])
  (:gen-class))

(defn eval-code
  [code]
  (lexer/scan code))

(defn repl
  []
  (print "< ")
  (flush)
  (let [code (read-line)]
    (println (eval-code code)))
  (repl))

(defn -main
  [& args]
  (when (nil? args)
    (repl))
  (if (> (count args) 0)
    (help/throw "usage: miniml")
    repl))