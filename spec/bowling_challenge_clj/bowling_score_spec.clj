(ns bowling-challenge-clj.bowling-score-spec
  (:require [speclj.core :refer :all]
            [bowling-challenge-clj.bowling-score :refer :all]))

(describe "Bowling Challenge - bowling-score function:"

  (it "adds the pins from the next roll as a bonus after a spare"
    (should= 18
      (bowling-score '((3 7) (4 0)))))

  (it "adds the pins from the next two rolls as a bonus after a strike"
    (should= 20
      (bowling-score '((10) (2 3)))))

  (it "calculates a perfect game to be worth 300 points"
    (should= 300
      (bowling-score '((10) (10) (10) (10) (10) (10) (10) (10) (10) (10 10 10)))))

  (it "can tell whether there was a strike in the frame"
    (should= true
      (strike? '(10))))

  (it "can tell whether there was a spare in the frame"
    (should= true
      (spare? '(3 7))))

  (it "can handle a strike in the last frame"
    (should= 15
      (bowling-score '((0 5) (10)))))

  (it "can handle an incomplete strike"
    (should= 12
      (bowling-score '((10) (1)))))

  (it "can handle a spare in the last frame"
    (should= 15
      (bowling-score '((0 5) (5 5)))))

  (it "two normal rolls should register false for spare? and strike?"
    (should= true
             (not (and (spare? '(5 5))
                       (strike? '(5 5)))))))

(run-specs)
