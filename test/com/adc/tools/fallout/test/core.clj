(ns com.adc.tools.fallout.test.core
  (:use [com.adc.tools.fallout.core :as ft])
  (:use [midje.sweet])
  )

(def easy-clue "FARTING")
(def easy-num-matches 3)                                                 
(def easy-possibles 
  [ "WANTING" 
    "WAITING" 
    "MASSIVE" 
    "MACHINE" 
    "DESPITE" 
    "FITTENS"]
  )

(def hard-clue "CIVILIZATION")
(def hard-num-matches 5)
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


(def helios-clue "WEAKEN")
(def helios-num-matches 2) 
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

(def repconn-clue "PROLONGED")
(def repconn-num-matches 5)
(def repconn-possibles
  [ "CRUMBLING"
    "CONVINCED"
    "WORSHIPER"
    "CONCERNED"
    "CLUTTERED"
    "CONVICTED"
    "COMPANIES"
    "COMPLETES"
    "CERTAINLY"
    "PROTECTED"
    "CONDUCTED"
    "CONVINCES"
    "CONCEALED"
    "CONQUORER"
    "COMMITTEE"
    "CONVERTED"
    "CURIOSITY" ]
  )


(def saspirilla-clue "REGARDING")
(def saspirilla-num-matches 5)
(def saspirilla-possibles
  [ "RECEIVING"
    "IMPORTANT"
    "REQUIRING"
    "BELIEVING"
    "RECYCLING"
    "DETHRONED"
    "OBTAINING"
    "LEUTENANT"
    "REPELLENT"
    "DETERRENT"
    "TELEPHONE"
    "HUMANKIND"
    "BELONGING"
    "UNDERWENT"
    "REMINDING"
    "RESILIENT"
    "DIFFERENT"
    "RELEASING" ])


(def hhtools-clue "CRUMBLING")
(def hhtools-num-matches 4)
(def hhtools-possibles [ 
                        "CRIMINALS"
                        "CONVINCED"
                        "CONCERNED"
                        "POISONING"
                        "REPAIRING"
                        "MOUNTAINS"
                        "CORPORATE"
                        "LEUTENANT"
                        "REPRIMAND"
                        "HAPPENING"
                        "CAPTURING" ])

(def hhtools-matches
  (ft/find-matches hhtools-clue hhtools-possibles hhtools-num-matches))

(def saspirilla-matches
  (ft/find-matches saspirilla-clue saspirilla-possibles saspirilla-num-matches))

(def repconn-matches
  (ft/find-matches repconn-clue repconn-possibles repconn-num-matches))

(fact 
  (indices helios-clue) => 
  '([0 \W] [1 \E] [2 \A] [3 \K] [4 \E] [5 \N]))


(fact
  (position #(= % \E) helios-clue) => 
  '(1 4))

(fact
  (overlap helios-clue (first helios-possibles)) =>
  #{[1 \E]}
  )

;(fact
;  saspirilla-matches => 
;  #{:clue "REGARDING", :matches ("RECEIVING" "REQUIRING" "RECYCLING" "RELEASING"), :at 5, :places ""})

;(fact
;  (sorted-overlaps helios-clue (nth helios-possibles (- (count helios-possibles) 2))) =>
;  #{[1 \A]}
;  )

(def helios-sorted-overlaps
  (sorted-overlaps helios-clue (get helios-possibles 11)))

(def easy-matches
  (ft/find-matches easy-clue easy-possibles easy-num-matches)
  )

(def hard-matches
  (ft/find-matches hard-clue hard-possibles hard-num-matches)
  )

(def helios-matches
  (ft/find-matches helios-clue helios-possibles helios-num-matches)
  )    

