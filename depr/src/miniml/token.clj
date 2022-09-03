(ns miniml.token
  (:require [miniml.help :as help]))

(defrecord Token
  [type content])

(help/make-token-def name :name)

;(def TokenType
;  (map
;    [:name
;     :num
;     :string
;     :lparen
;     :rparen
;     :ident
;     :eof] (fn [t] (help/return #(t)))))