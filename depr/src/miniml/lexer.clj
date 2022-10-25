(ns miniml.lexer
  (:require
    [miniml.help :as help]
    [miniml.token :as token]))

(defn scan
  [string]
  (let [f #(case %1
             "" %2
             (let [r (scan-char %1)]
               (f (first r) (conj %2 (last r)))))]
    (help/return
      (f string []))))

(defn scan-char
  [string]
  (let [c (first string)]
    (help/return
      (case c
        \( (token/new :lparen c)
        \) (token/new :rparen c)
        (help/throw (str "i dont know what you want with { " c " }"))))))

(println (token/to-str (scan "(")))
