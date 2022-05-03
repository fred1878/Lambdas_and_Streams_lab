package org.example.streamapi;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MVP {

    /*
        Convert a List<String> to an object stream and for each element -> System,out.println.
     */

    public void printNames(List<String> names) {
        Stream<String> stream = names.stream();
        stream.forEach(s -> System.out.println(s));
    }

    /*
        Given a List<Integers>, return a List<Integer> with event numbers.
     */
    public List<Integer> returnEvenNumbers(List<Integer> numbers) {
        Stream<Integer> stream = numbers.stream();
        List<Integer> list = stream.filter(o -> o % 2 == 0).collect(Collectors.toList());
        return list;
    }

    /*
        Given an int [], double the value of each int and return an int [].
    */
    public int[] doubleInts(int[] numbers) {
        IntStream stream = Arrays.stream(numbers);
        int[] array = stream.map(o -> o*2).toArray();
        return array;
    }

    /*
        Given a String, return a List<String>, all caps.
     */
    public List<String> splitToAllCapsList(String input) {
        List<Character> chars = input.chars().map(Character::toUpperCase).mapToObj(e -> (char)e).collect(Collectors.toList());
        List<String> string = chars.stream().map(String::valueOf).collect(Collectors.toList());
        return string;
    }

    /*
    Given a list of animals:
     - filter the ones that start with a given letter
     - return sorted List<String>, all caps.
    */
    public List<String> filterByFirstLetterAndOrder(List<String> list, String letter) {
        Stream<String> stream = list.stream();
        List<String> result = stream.filter(s -> s.startsWith(letter)).sorted().map(String::toUpperCase).collect(Collectors.toList());
        return result;
    }

    /*
        Given a list of words, return elements that:
         - are shorter than the given number and
         - start with a given letter.
    */
    public List<String> filterWords(List<String> words, int maxLength, String firstLetter) {
        Stream<String> stream = words.stream();
        List<String> result = stream.filter(s -> s.startsWith(firstLetter)).filter(s -> s.length()<maxLength).collect(Collectors.toList());
        return result;
    }
}