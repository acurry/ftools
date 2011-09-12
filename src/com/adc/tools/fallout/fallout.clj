(ns fallout.tools
  (:require [clojure.set :as s]))

(defn indices 
  "Returns a seq of vectors of the form ([idx] [item]...) where 
  idx is the index of item in coll."
  [coll]
  (cond
    (map? coll) (seq coll)
    (set? coll) (do (println coll) (map vector coll coll))
    :else (map vector (iterate inc 0) coll)))

(defn position  
  "Returns the index of the first item in coll where 
  (pred item) is true."
  [pred coll]
  (for 
    [[i v] (indices coll) :when (pred v)] i
    )
  )

(defn overlap 
  "Returns the set-wise intersection of coll1 and coll2."
  [coll1 coll2] 
  (s/intersection 
    (set (indices coll1)) 
    (set (indices coll2))
    )
  )

(defn sorted-overlaps 
  "Returns a seq of overlaps of coll1 and coll2 
  where each overlap is sorted according to the 
  first item of each of its items."
  [coll1 coll2]
  (map
    sort
    (map overlap coll1 coll2))
  )

(defn mapped-sorted-overlaps
  "Returns a seq of foo's overlaps on each item in coll."
  [foo coll]
  (sorted-overlaps
    (replicate (count coll) foo)
    (seq possibles)
    )
  )

(defn prune-overlaps-by-matches 
  "Return a seq of items where alpha equals 
  the second part of each item in coll."
  [alpha coll]
  (filter
    #(= (second %) alpha)
    (indices (map count coll))
    )
  )

(defn matching-overlaps 
  "Return a seq of items from coll1 where
  the first of each item in coll2 are the indices
  of items in coll1 to return."
  [coll1 coll2]
  (map 
    #(nth coll1 %) 
    (map 
      #(first %) 
      coll2
      )
    )
  )

(defn find-matches [alpha betas matches]
  "Return a seq containing items from betas
  where alpha has the same members at the same indexes
  according to matches."
  (let [possible-overlaps
        (sorted-overlaps (replicate (count betas) alpha) (seq betas))
        pruned-beta-overlaps
        (prune-overlaps-by-matches matches possible-overlaps)]
    {:clue alpha :matches (matching-overlaps betas pruned-beta-overlaps) :at matches}
    )
  )

