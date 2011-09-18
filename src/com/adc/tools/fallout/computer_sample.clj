(ns com.adc.tools.fallout.computer-sample
  (:require [com.adc.tools.fallout.core :as ft]))

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

(def helios-clue "WEAKEN")
(def helios-possibles
  [ "HERALD"
    "PERISH"
    "HEATED"
    "SERIES"
    "BETTER"
    "CENTER"
    "MEMORY"
    "MENTAL"
    "WORTHY"
    "MURDER"
    "BEATEN"
    "CRATER"
    "TESTED"]
  )

(def helios-num-matches 2)

(def helios-matches
  (ft/find-matches helios-clue helios-possibles helios-num-matches)
  )


;(def easy-clue-possible-overlaps 
;  (ft/mapped-sorted-overlaps 
;    (replicate (count easy-possibles) easy-clue) 
;    (seq easy-possibles)
;    )
;  )


;(def easy-pruned-possibles 
;  (ft/prune-overlaps-by-matches
;    easy-num-matches
;    ft/clue-possible-overlaps)
;  )

(def easy-matches
  (ft/find-matches easy-clue easy-possibles easy-num-matches)
  )

(def hard-matches
  (ft/find-matches hard-clue hard-possibles hard-num-matches)
  )

