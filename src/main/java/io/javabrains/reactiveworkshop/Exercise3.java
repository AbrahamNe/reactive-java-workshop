package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.List;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        List<Integer> numbers = ReactiveSources
                .intNumbersFlux()
                .log()
                .toStream()
                .toList();
        // its a blocking waits until it gets all the values
        System.out.println("list is " + numbers);
        System.out.println("size " + numbers.size());

        System.out.println("Press a key to end");
        System.in.read();
    }

}
