(ns primes)

(defn p-filter [start coll] 
  (filter 
    (fn [x] 
      (or 
        (= x start) 
        (not= (mod x start) 0)
        )
      ) coll
    )
  )

(defn p-range [end]
  (range 2 (+ 1 end))
  )

(defn primes [max]
  (loop [inc 0 start 2 l-primes (p-range max)]
    (if 
      (> (* (nth l-primes inc) (nth l-primes inc)) max)
      l-primes
      (recur 
        (+ 1 inc) (nth l-primes inc) (p-filter (first l-primes) (rest l-primes))
        )
      )
    )
  )


