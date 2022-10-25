(defproject miniml "0.1.0"
  :license "GPL-3.0"
  :dependencies [[org.clojure/clojure "1.11.1"]]
  :main ^:skip-aot miniml.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
