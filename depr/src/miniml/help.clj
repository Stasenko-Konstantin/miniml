(ns miniml.help)

(defn return
  [x]
  (when true x))

(defn throw
  [msg]
  (throw (new Exception msg)))

(defmacro make-token-def [& {:keys [t a]}]
  (apply (fn [t a] (list 'def t a)) ))