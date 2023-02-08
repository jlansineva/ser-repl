(ns ser.domain)

(def pizzerias [{:id 1
                 :name "Da Mario"}
                {:id 2
                 :name "Da Max"}
                {:id 3
                 :name "Plan B"}
                {:id 4
                 :name "Turtles"}])

(def pizzas
  [{:id 1 :pizzeria 1 :name "Mexicana" :price-eur 12 :toppings [:pineapple :pepperoni :garlic :jalapeno]}
   {:id 2 :pizzeria 1 :name "Parma" :price-eur 11 :toppings [:airdried-ham :mozzarella :cherry-tomato :parmesan :rucola]}
   {:id 3 :pizzeria 1 :name "Alla Pollo" :price-eur 13 :toppings [:marinated-chicken :feta :onion :tomato]}
   {:id 4 :pizzeria 1 :name "Ciao Ciao" :price-eur 12 :toppings [:ham :tuna :shrimps]}
   {:id 5 :pizzeria 1 :name "Kebab Pizza" :price-eur 14 :toppings [:kebab :mushrooms :onion :garlic]}

   {:id 6 :pizzeria 2 :name "Tropicana" :price-eur 10 :toppings [:pineapple :ham :auracheese]}
   {:id 7 :pizzeria 2 :name "Mexicana" :price-eur 10 :toppings [:pineapple :minced-meat :garlic :jalapeno]}
   {:id 8 :pizzeria 2 :name "Piccante" :price-eur 9 :toppings [:ham :salami :mushrooms :peppers]}
   {:id 9 :pizzeria 2 :name "Tex mex" :price-eur 9 :toppings [:minced-meat :pepperoni :jalapeno :nachos :salad :chili-mayo]}
   {:id 10 :pizzeria 2 :name "Max" :price-eur 12 :toppings [:kebab :mushrooms :onions :peppers :mayonaise]}

   {:id 11 :pizzeria 3 :name "Bedollo" :price-eur 15 :toppings [:kebab :pepperoni :ham :bacon :mayonaise]}
   {:id 12 :pizzeria 3 :name "BBQ plan" :price-eur 14 :toppings [:bbq-sauce :jalapeno :shrimps :red-peppers :salami]}
   {:id 13 :pizzeria 3 :name "Hot plan" :price-eur 14 :toppings [:pineapple :pepperoni :garlic :mexicana-sayce :bacom]}
   {:id 14 :pizzeria 3 :name "Americana" :price-eur 13 :toppings [:pineapple :ham :auracheese]}
   {:id 15 :pizzeria 3 :name "Veggie plan" :price-eur 13 :toppings [:mushrooms :auracheese :cherry-tomato :red-peppers]}

   {:id 16 :pizzeria 4 :name "Leonardo" :price-eur 15 :toppings [:kebab :chicken :onion :fries :mayonaise]}
   {:id 17 :pizzeria 4 :name "Donatello" :price-eur 16 :toppings [:pesto :mozzarella :basil :rucola :cherry-tomatoes]}
   {:id 18 :pizzeria 4 :name "Rafaello" :price-eur 17 :toppings [:chorizo :mushrooms :parmesan :rucola :cherry-tomato]}
   {:id 19 :pizzeria 4 :name "Michelangelo" :price-eur 16 :toppings [:bresaola :cherry-tomato :rucola :parmesan :mayonaise]}
   {:id 20 :pizzeria 4 :name "Chelsea" :price-eur 12 :toppings [:chicken :pineapple :auracheese :mayonaise]}])
