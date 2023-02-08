(ns ser.core
  (:gen-class)
  (:require
   [ser.routes]
   [mount.lite :as mount]))

(defn start []
  (mount/start))

(defn stop []
  (mount/stop))

(defn -main
  "Just start the thing"
  [& _]
  (start))
