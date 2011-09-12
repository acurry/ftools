(ns fallout.tools)

(def easy-clue "FARTING")
(def easy-possibles 
  [ "WANTING" 
    "WAITING" 
    "massive" 
    "machine" 
    "despite" 
    "fittens"]
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
    clue-possible-overlaps)
  )

(def easy-matches
  (find-matches easy-clue easy-possibles easy-num-matches)
  )

(def hard-matches
  (find-matches hard-clue hard-possibles hard-num-matches)
  )

