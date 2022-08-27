(ns miniml.token
  (:require [miniml.help :as help]))

(defrecord Token
  [type content])
;
;(def TokenType
;  (map
;    [:name
;     :num
;     :string
;     :bool
;
;     :lparen
;     :rparen
;     :let
;     :case
;     :in
;     :not
;     :plus                                                  ;; +
;     :minus                                                 ;; -
;     :mul                                                   ;; *
;     :div                                                   ;; /
;     :eq                                                    ;; ==
;     :gt                                                    ;; >
;     :lt                                                    ;; <
;
;     :ident
;     :eof] (fn [t] (help/return #(t)))))