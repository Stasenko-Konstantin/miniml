(ns miniml.token
  (:require [miniml.help :as help]))

(defrecord Token
  [type content])

(defmacro new
  "make new Token"
  [t c]
  (->Token (if (some #{t} '(:name
                             :num
                             :string
                             :bool

                             :lparen
                             :rparen
                             :let
                             :rec
                             :in
                             :case
                             :not
                             :bind                          ;; =
                             :plus                          ;; +
                             :minus                         ;; -
                             :mul                           ;; *
                             :div                           ;; /
                             :eq                            ;; ==
                             :gt                            ;; >
                             :lt                            ;; <

                             :ident
                             :eof))
             t
             (help/throw (str "not found " t " token type")))
           c))

(defn to-str
  [t]
  (str (:type t) ", " (:content t)))
