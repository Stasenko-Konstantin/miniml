(ns miniml.error)

(defn throw
  [msg]
  (throw (new Exception msg)))