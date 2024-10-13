package edu.pro;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) throws IOException {
    LocalDateTime start = LocalDateTime.now();

    String[] words = new String(Files.readAllBytes(Paths.get("src/edu/pro/txt/harry.txt")))
            .replaceAll("[^\\w']+", " ")
            .toLowerCase()
            .split(" ");

    Map<String, Integer> wordCount = new HashMap<>();

    for (String word: words){
      wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
    }

    wordCount
            .entrySet()
            .stream()
            .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
            .limit(30)
            .forEach(entry ->  {
              System.out.println((entry.getKey() + " " + entry.getValue()));
            });

    LocalDateTime finish = LocalDateTime.now();

    System.out.println("------");
    System.out.println(ChronoUnit.MILLIS.between(start, finish));

  }
}
