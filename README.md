# Bowling-Challenge: Clojure edition

This is a function which can calculate the total score for a given bowling scorecard.
The project was coded following TDD and Speclj was chosen as the testing framework.

The main function is called `bowling-score` and takes a single `scorecard` argument and is called like so:
```clj
user=> (bowling-score '((10) (2 3)))
20
```
The `scorecard` is provided as a list of nested lists. Each nested list represents a bowling frame so there should be no more than 10 frames/nested lists per game, and all but the tenth frame should not exceed more than 2 elements/rolls.

Lists were chosen for the data-structure as the bowling scoring system lends itself nicely to a linked-list structure: most often, the function is only interested in at most the first 3 rolls, and functionality is not required for random access of the nth element in the list.

A recursive algorithm was chosen to calculate the bowling score because this takes advantage of the linked-list scorecard structure. `bowling-score` calls `frame-score` on each frame then sums them all up.
`frame-score` is responsible for determining whether to calculate the appropriate `strike-score` or `spare-score` in the case of a strike or spare respectively.

## Installation


### Getting Clojure:
In order to run Clojure, Java is required. Instructions for this can be found here: https://www.java.com/en/download/

After installing Java, install the dependency manager for Clojure, Leiningen, from here http://leiningen.org/


### Running tests:

Speclj is included in Leiningen so after this tests can be run by running the command:

```
$lein spec -f d
```