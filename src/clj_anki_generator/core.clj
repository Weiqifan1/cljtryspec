(ns clj-anki-generator.core
  (:require [clojure.spec.alpha :as s]
            [clojure.spec.test.alpha :as stest]
            [clojure.test.check.generators]
            [clojure.pprint :refer [pprint]]

            ;[clj-anki-generator.helperfunctions :as helper]
            ;[clj-anki-generator.core-spec :as core-s]
            ;[clj_anki_generator.spec :as myspec]
))

(load-file "src/clj_anki_generator/helperfunctions.clj")
(load-file "src/clj_anki_generator/core_spec.clj")



(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println (str "Hello, World! develop2 "))) ;(helper_addNumbers 2 6))))

  ;(println (str "Hello, World! develop2" (ranged-rand 2 6))))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
; spec eksempel 2 (med et spec defineret i en anden fil)
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
(s/fdef repeat-string
  :args (s/cat :inputStr ::text)
  :ret ::text
  )
(defn repeat-string [inputStr] (str inputStr " " inputStr))

(stest/instrument `repeat-string)
(stest/check `repeat-string)
;(pprint (s/exercise ::text))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
                                        ;spec eksemel
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn ranged-rand
  "returns random int in range start <= rand <"
  [start end]
  (+ start (long (rand (- end start))))
  )

(s/fdef ranged-rand
  :args (s/and (s/cat :start nat-int? :end nat-int?)
               #(< (:start %) (:end %)))
  :ret int?
  :fn (s/and #(>= (:ret %) (-> % :args :start))
             #(< (:ret %) (-> % :args :end))))
(stest/instrument `ranged-rand)
(stest/check `ranged-rand)
;(def myVar (ranged-rand 3 7))
;(def myVar (ranged-rand -3 7))



;slut
