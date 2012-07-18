(ns ftools.routes
  (:use compojure.core)
  (:require [compojure.route :as route]))

(defroutes app
  (GET "/" [] "<h1>hey</h1>")
  (route/not-found "not found"))

