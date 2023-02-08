(ns ser.integration
  (:require [clj-http.client :as client]
            [muuntaja.core :as m]))

(def coingecko-simple-price "https://api.coingecko.com/api/v3/simple/price")
;; ?ids=bitcoin&vs_currencies=eur

(defn http-get
  ([]
   (http-get "https://dummyjson.com/products" {}))
  ([uri]
   (http-get uri {}))
  ([uri params]
   (client/get uri
     {:accept :json :query-params params})))
