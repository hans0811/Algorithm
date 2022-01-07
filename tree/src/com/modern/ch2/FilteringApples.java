package com.modern.ch2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class FilteringApples {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(128, "red")
        );

        List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
        System.out.println(greenApples);

        List<Apple> heavyApples = inventory.stream()
                .filter((Apple a) -> a.getWeight() > 150)
                .collect(toList());

        System.out.println(heavyApples);

        List<Apple> heavyApplesParallel = inventory
                .parallelStream()
                .filter((Apple a) -> a.getWeight() > 150)
                .collect(toList());

        System.out.println(heavyApplesParallel);



    }


    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple:inventory){
            if("green".equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory) {
            if(apple.getWeight() > 150){
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isGreenApple(Apple apple) {
        return "green".equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple){
        return apple.getWeight() > 50;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }



}
