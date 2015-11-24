(ns bowling-challenge-clj.bowling-score-spec
  (:require [speclj.core :refer :all]
            [bowling-challenge-clj.bowling-score :refer :all]))

(describe "Bowling Challenge:"
  (it "a spare adds the pins from the next two rolls as a bonus" 
    (should= 18
      (bowling-score '((3 7) (4 0)))))
  (it "a strike adds the pins from the next two rolls as bonus"
    (should= 20
      (bowling-score '((10) (2 3)))))
  (it "a perfect game is worth 300 points"
    (should= 300
      (bowling-score '((10) (10) (10) (10) (10) (10) (10) (10) (10) (10 10 10))))) 
  (it "can tell whether there was a strike in the frame"
    (should= true
      (strike? '(10))))
  (it "can tell whether there was a spare in the frame"
    (should= true
      (spare? '(3 7))))
  (it "two normal rolls should register false for spare? and strike?"
    (should= true
             (not (and (spare? '(5 5))
                       (strike? '(5 5))))))
)
 
(run-specs)
