(ns miniml.lexer
  (:require
    [miniml.help :as help]
    [miniml.token :as token]))

(defn scan
  [string]
  ;(let [t (token/new :eof " ")]
  ;  (println (token/to-str t)))
  (let [c (first string)]
    (help/return
      (cond                                                 ; change to match macros. dont like this boilerplate
        (= c \() (token/new :lparen c)
        (= c \)) (token/new :rparen c)
        :else (help/throw (str "i dont know what you want with { " c " }"))))))

(println (token/to-str (scan "(")))
