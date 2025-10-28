package javafeatures.streams;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Example demonstrating the use of Java Streams API.
 */
public class StreamsEx {
    public static void main(String[] args) {
        // Example usage of Java Streams
        int[] numbers = {1, 2, 3, 4, 5};

        // Calculate the sum of squares of even numbers
        int sumOfSquares = Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .sum();

        System.out.println("Sum of squares of even numbers: " + sumOfSquares);

        // Calculate the average of all numbers
        double average = Arrays.stream(numbers)
                .average()
                .orElse(0);

        System.out.println("Average of all numbers: " + average);

        // Create a comma-separated string of all numbers
        String commaSeparated = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .reduce((a, b) -> a + ", " + b)
                .orElse("");

        System.out.println("Comma-separated numbers: " + commaSeparated);

        // Print the words and their counts from a sentence
        String sentence = "Hi, how are you doing today? Hope you are doing great!";
        Map<String, Long> counts = Arrays.stream(sentence.split("[\\W]+"))
                .map(String::toLowerCase)
                .filter(s -> !s.isEmpty())
                .collect(java.util.stream.Collectors.groupingBy(w -> w, Collectors.counting()));

        counts.forEach((word, count) -> System.out.println(word + ": " + count));


    }
}
