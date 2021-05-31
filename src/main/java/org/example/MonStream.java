package org.example;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;//

public class MonStream {
    public static void useListOfNumbers() {
        List<Integer> listOfNumbers = List.of(1, 2, 3, 4, 5, 6, 7, 8);
/**
 * Utilisation du takeWhile selon un modulo de 2
 * sur n qui est un élément de listOfNumbers
 * On affiche dans le forEach de façon automatique les valeurs de la liste
 */
        listOfNumbers.stream().takeWhile(n -> n % 2 == 1).forEach(i-> System.out.print(i + ", "));
    }

    public static void useListOfNumbers2() {
        Set<Integer> setOfNumbers = Set.of(1, 2, 3, 4, 5);
/**
 * foreach sur le contenu :
 * setOfNumbers = Set.of(1, 2, 3, 4, 5);
 * avec un test si la value est = 1 alors j'affiche
 * un message comme "titre" : "setOfNumbers"
 * et affiche la value
 */
        setOfNumbers.forEach(value -> {
            if(value == 1) System.err.println("setOfNumbers");
            System.out.print(value + ", ");
        });
    }

    public static void useListOfNumbers3() {
        Map<String, String> mapOfString = Map.of("key1", "value1", "key2",
                "value2");
/**
 * Affiche d'une map avec sa Key et sa valeur
 * dans un foreach
 */
        System.err.println("mapOfString");
        mapOfString.forEach((key,value)-> System.out.println(key+"-"+value));
    }

    public static void streamiterator() {
        /**
         * Iterator automatique comme for(int ..;..;..)
         */
        System.out.println("De 2 en 2(seed) jusqu'à 10:");
        Stream.iterate(2, i -> i < 10, i -> i + 2).forEach(i-> System.out.print(i + ", "));
        System.out.println("\n");

/**
 * Affiche "ab"
 **/
        System.out.println("Tant que C ne passe pas:");
        Stream.of("a", "b", "c", "d").takeWhile(s -> !s.equals("c")).forEach(i-> System.out.print(i + ", "));
        System.out.println("\n");

/**
 * Affiche "cd"
 **/
        System.out.println("Quand C passe:");
        Stream.of("a", "b", "c", "d").dropWhile(s -> !s.equals("c")).forEach(i-> System.out.print(i + ", "));
        System.out.println("\n");
    }
}