(ns learn_clj.core)

(defn -main [] (println "Hello, World!") 2)

(defn plus [x] x + 1)

(defn min [x] x - 1)

(def Y (fn [f]
         ((fn [x]
            (x x))
          (fn [x]
            (f (fn [y]
                 ((x x) y)))))))

(def Y1 (fn [f]
          ((fn [x]
             (x x))
           (fn [x]
             (f
              (x x))))))

(def factorial-gen (fn [func]
                     (fn [n]
                       (if (zero? n)
                         1
                         (* n (func (dec n)))))))

(def fib-gen (fn [func]
               (fn [n]
                 (case n
                   0 0
                   1 1
                   (+ (func (dec n)) (func (dec (dec n))))))))

((Y factorial-gen) 19)

((Y fib-gen) 100)
