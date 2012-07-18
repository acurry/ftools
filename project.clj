(defproject ftools "1.0.0-SNAPSHOT"
  :description "Fallout tools written in clojure"
  :main ftools.core
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.1.1"]
                 [hiccup "1.0.0"]]
  :ring {:handler ftools.routes/app}
  )
