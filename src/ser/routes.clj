(ns ser.routes
  (:require
   [ser.db :as db]
   [ser.integration :as integration]
   [muuntaja.core :as m]
   [mount.lite :as mount]
   [reitit.ring :as r]
   [reitit.coercion.spec]
   [reitit.swagger :as swagger]
   [reitit.swagger-ui :as swagger-ui]
   [reitit.ring.coercion :as rrc]
   [reitit.ring.middleware.muuntaja :as muuntaja]
   [reitit.ring.middleware.parameters :as parameters]
   [ring.adapter.jetty :as jetty]))

;; use db/get-pizzerias
;; a stateless handler
(defn get-pizzas
  [{{{} :query} :parameters}]
  {:status 200
   :body {:pizzas (db/get-pizzas)}})

(defn get-pizzerias
  [_]
  {:status 200
   :body {:pizzerias (db/get-pizzerias)}})

(defn get-pizza-with-topping
  [{{{:keys [topping]} :query} :parameters}]
  {:status 200
   :body {:pizzas (filter #(some #{(keyword topping)} (:toppings %))
                    (db/get-pizzas))}})

;; the app itself, it's all stateless
(def app
  (r/ring-handler
    (r/router
      ["/api"
       ["/swagger.json"
        {:get {:no-doc true
               :swagger {:info {:id "SER"
                                :title "SER"
                                :description ""
                                :version "v1"}}
               :handler (swagger/create-swagger-handler)}}]

       ["/admin" {:get {:parameters {:query {:username string? :password string?}}
                        :handler (constantly {:status 200 :body {:admin true}})}}]

       ["/pizzas" {:get {:handler get-pizzas}}]
       ["/pizzerias" {:get {:handler get-pizzerias}}]
       ["/pizza"
        ["/topping" {:get {:parameters {:query {:topping string?}}
                           :handler get-pizza-with-topping}}]]]



      {:data {:coercion reitit.coercion.spec/coercion
              :muuntaja m/instance
              :middleware [swagger/swagger-feature
                           parameters/parameters-middleware
                           rrc/coerce-request-middleware
                           muuntaja/format-response-middleware
                           rrc/coerce-response-middleware]}})
    (r/routes
      (swagger-ui/create-swagger-ui-handler
        {:path "/api"
         :url "/api/swagger.json"
         :config {:validatorUrl nil
                  :operationsSorter "alpha"}})
      (r/create-default-handler))))

(comment
  (m/decode "application/json"
    (:body
     (app {:request-method :get
           :uri "/api/pizzas"
           :query-params {}})))
  (get-pizza-with-topping {:parameters {:query {:topping "pineapple"}
                                        }})

  (m/decode "application/json"(:body (app {:request-method :get
                                           :uri "/api/pizzerias"})))

  (m/decode "application/json" (:body (app {:request-method :get
                        :query-params {:topping "pineapple"}
                        :uri "/api/pizza/topping"})))

  #_(app {:request-method :get
          :uri "/api/pizzeria/menu"})

  #_(app {:request-method :get
          :uri "/api/pizza/bitcoin"})

  #_#_#_(some #{ a key } collection) => key
  )

(mount/defstate server
  :start (do
           (println "starting server")
           (jetty/run-jetty #'app {:port 8880 :join? false}))
  :stop (do (println "stopping server")
            (.stop @server)))
