package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.Optional;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        // ---its non-blocking
        ReactiveSources.intNumberMono().subscribe(
                System.out::println);

        // ------- subscribe returns either 3 items
//        ReactiveSources.intNumberMono().subscribe(
//                numbers -> System.out.println(numbers),
//                err -> System.out.println(err.getMessage()),
//                () -> System.out.println("Completed"));

        // Get the value from the Mono into an integer variable
        // ---blocks until it gets a value
        Optional<Integer> number = ReactiveSources.intNumberMono().blockOptional();

        User user = ReactiveSources.userMono().block();
        System.out.println(number.get());
        System.out.println("Press a key to end");
        System.in.read();
    }

}
