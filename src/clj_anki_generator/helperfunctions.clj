(ns clj_anki_generator.helperfunctions
  (:require [clojure.spec.alpha :as s]
            [clojure.spec.test.alpha :as stest]
            [clojure.test.check.generators]
            [clojure.pprint :refer [pprint]]
))

(defn helper_addNumbers
  "add two numbers"
  [numOne numTwo]
  (+ numOne numTwo))



;slut
