(ns ser.db
  (:require [ser.domain :as domain]))

(defn get-pizzas []
  domain/pizzas)

(defn get-pizzerias []
  domain/pizzerias)
