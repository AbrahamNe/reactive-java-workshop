package io.javabrains.reactiveworkshop;

import java.io.IOException;

// Flux to Mono
public class Exercise9 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Print size of intNumbersFlux after the last item returns

        // -- waits until the last operator runs
//        ReactiveSources.intNumbersFlux().count()
//                .subscribe(System.out::println);

        // Collect all items of intNumbersFlux into a single list and print it
        // using non-blocking way
//        ReactiveSources.intNumbersFlux().collectList()
//                .log()
//                .subscribe(System.out::println);

        // Transform to a sequence of sums of adjacent two numbers
        ReactiveSources.intNumbersFlux()
                .log()
                .buffer(2)
                .map(list -> list.get(0) + list.get(1))
                .subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
