package com.ambev.abichallenge.util

import spock.lang.Specification
import spock.lang.Unroll

class ScoreCalculatorTest extends Specification {


    @Unroll
    def "Score calculator - test distance score"() {
        when:
        def result = ScoreCalculator.shortestDistanceScore(distance)

        then:
        result == expectedScore

        where:
        distance | expectedScore
        -1       | 0
        0        | 100
        5        | 100
        10       | 75
        15       | 50
        20       | 25
        21       | 0
    }

    @Unroll
    def "Score calculator - quantity capacity ratio"(){
        when:
        def result = ScoreCalculator.quantityCapacityRatio(quantity, capacity)

        then:
        result == expectedRatio

        where:
        quantity | capacity  | expectedRatio
        0        | 10        | 75
        -1       | 10        | 75
        10       | 20        | 75
        20       | 20        | 100
        30       | 20        | 75
    }

    @Unroll
    def "Score calculator - Calculate score"(){
        when:
        def result = ScoreCalculator.calculateScore(quantity, capacity, shortestDistance)

        then:
        result == expectedScore

        where:
        quantity | capacity  | shortestDistance | expectedScore
        0        | 10        | 0                | 87
        -1       | 10        | 25               | 37
        10       | 20        | 50               | 37
        20       | 20        | 75               | 50
        30       | 20        | 100              | 37
    }
}
