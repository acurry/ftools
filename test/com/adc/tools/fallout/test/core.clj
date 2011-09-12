(ns com.adc.tools.fallout.test.core
  (:use [com.adc.tools.fallout.core])
  (:use [clojure.test])
  (:use midje.sweet))

(def easy-clue "FARTING")
(def easy-possibles 
  [ "WANTING" 
    "WAITING" 
    "MASSIVE" 
    "MACHINE" 
    "DESPITE" 
    "FITTENS"]
  )
(def easy-num-matches 3)                                                 

(def hard-clue "CIVILIZATION")
(def hard-possibles 
  [ "REPRIMANDING"
    "PARTNERSHIPS"
    "APPRECIATION"
    "CONVERSATION"
    "CIRCUMSTANCE"
    "PURIFICATION"
    "SECLUSIONIST"
    "CONSTRUCTION"
    "DISAPPEARING"
    "TRANSMISSION"
    "APPREHENSIVE"
    "ENCOUNTERING"]
  )
(def hard-num-matches 5)


(def easy-clue-possible-overlaps 
  (mapped-sorted-overlaps 
    (replicate (count easy-possibles) easy-clue) 
    (seq easy-possibles)
    )
  )


(def easy-pruned-possibles 
  (prune-overlaps-by-matches
    easy-num-matches
    easy-clue-possible-overlaps)
  )

(def easy-matches
  (find-matches easy-clue easy-possibles easy-num-matches)
  )

(def hard-matches
  (find-matches hard-clue hard-possibles hard-num-matches)
  )

