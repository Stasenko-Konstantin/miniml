(ns miniml.help)

(defn return
  [x]
  (when true x))

(defn throw
  [msg]
  (throw (new Exception msg)))