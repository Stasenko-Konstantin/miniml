(ns miniml.core
  "simple ML interpreter"
  (:require
    [miniml.error :as error]
    [miniml.help :as help])
  (:gen-class))

(defn eval-code
  [code]
  (help/return code))

(defn eval-file
  [file]
  (eval-code file))

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
  (cond
    (> (count args) 1 (error/throw "usage: miniml [file.ml]"))
    (= (count args) 1 (eval-file (first args)))
    :else repl))