(ns kaprekar)

(defn kap [n]
  (-
    (Integer. (apply str (reverse (sort (str n)))))
    (Integer. (apply str (sort (str n))))
    )
  )

(defn kap-sequence [n]
   (loop [k n kaps [-1]]
     (if
       (or (= k 0) (= (kap k) (last kaps))) kaps
       (recur (kap k) (conj kaps (kap k)))
       )
     )
  )
