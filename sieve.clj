(ns sieve)

(defn s-filter [start coll] 
  (filter 
    (fn [x] 
      (or 
        (= x start) 
        (not= (mod x start) 0)
        )
      ) coll
    )
  )

(defn s-range 
  ([end] (range 2 (+ 1 end)))
  ([start end] (range start (+ 1 end)))
  )

(defn square-less-than-max [element max]
  (> (* element element) max)
  )

(defn sieve 
  ([upper] 
   (loop [index 0 primes (s-range 2 upper)]
            (if 
              (square-less-than-max (nth primes index) upper)
              primes
              (recur 
                (+ 1 index) (s-filter (nth primes index) primes)
                )
              )
            )
   )
  )

(defn sieve-palindrome
  ([upper] 
   (loop [index 0 primes (s-range 2 upper)]
            (if 
              (square-less-than-max (nth primes index) upper)
              primes
              (recur 
                (+ 1 index) (s-filter (nth primes index) primes)
                )
              )
            )
   )
  )


; doesn't work yet - need to figure out
; how to capture all the primes less than lower
; and pump them in to filter out their multiples
(defn sieve-bounded
  ([lower upper] 
   (loop [index 0 primes (s-range lower upper)]
            (if 
              (square-less-than-max (nth primes index) upper)
              primes
              (recur 
                (+ 1 index) (s-filter (nth primes index) primes)
                )
              )
            )
   )
  )


