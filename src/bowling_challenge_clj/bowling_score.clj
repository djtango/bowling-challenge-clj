(ns bowling-challenge-clj.bowling-score)

(defn strike? [frame]
  (= (first frame)
     10))

(defn spare? [frame]
  (and
    (not (strike? frame))
    (= (reduce + frame)
       10)))

(defn next-2-rolls [rolls]
  (cond
    (empty? rolls)
      '(0)
    (= (count rolls) 1)
      (let [first-bonus (first rolls)]
      (list (first rolls))
    :else (cons first-bonus (first (rest rolls))))))

(defn strike-score [scorecard]
  (+ (first (first scorecard))
    (reduce + (next-2-rolls (rest (flatten scorecard))))))

(defn next-roll [scorecard]
  (if (empty? scorecard)
    0
    (first (first scorecard))))

(defn spare-score [scorecard]
  (+ (reduce + (first scorecard))
     (next-roll (rest scorecard))))

(defn frame-score [scorecard]
  (let [frame (first scorecard)]
    (cond
     (strike? frame)
       (strike-score scorecard)
     (spare? frame)
       (spare-score scorecard)
     :else (reduce + frame))))

(defn bowling-score [scorecard]
  (if (= (count scorecard) 0)
    0
    (+ (frame-score scorecard)
       (bowling-score (rest scorecard)))))
