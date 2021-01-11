package com.ambev.abichallenge.util;

public class ScoreCalculator {

    public static int calculateScore(int quantity, int vehicleCapacity, int shortedDistanceBetweenVehicleAndStore){
        return (quantityCapacityRatio(quantity, vehicleCapacity)
                + shortestDistanceScore(shortedDistanceBetweenVehicleAndStore))/ 2;
    }

    public static int quantityCapacityRatio(int quantity, int vehicleCapacity){
        return 100 - 25 * Math.abs((quantity - vehicleCapacity) / 10);
    }

    /**
     * 0 to 5	100
     * more than 5 until 10	75
     * more than 10 until 15	50
     * more than 15 until 20	25
     * bigger than 20	0
     */
    public static int shortestDistanceScore(int distance){
        if (distance >= 0 && distance <= 5){
            return 100;
        } else if (distance > 5 && distance <= 10){
            return 75;
        } else if (distance > 10 && distance <= 15){
            return 50;
        } else if (distance > 15 && distance <= 20){
            return 25;
        }
        return 0;
    }

}
