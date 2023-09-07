package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise7 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Print all values from intNumbersFlux that's greater than 5
        // TODO: Write code here
//        ReactiveSources.intNumbersFlux()
//                .log()
//                .filter(number -> number > 5)
//                //.log() // gets the log after the filter executed
//                .subscribe(System.out::println);

        // Print 10 multiplied by each value from intNumbersFlux that's greater than 5

//        ReactiveSources.intNumbersFlux()
//                .filter(number -> number > 5)
//                .map(x -> x * 10) // returns flux
//                .subscribe(System.out::println);

        // Print 10 multiplied by each value from intNumbersFlux
        // for the first 3 numbers emitted that's greater than 5

//        ReactiveSources.intNumbersFlux()
//                .filter(number -> number > 5)
//                .map(x -> x * 10)
//                .take(3)
//                .subscribe(System.out::println);
        // Print each value from intNumbersFlux
        // that's greater than 20. Print -1 if no elements are found

//        ReactiveSources.intNumbersFlux()
//                .filter(number -> number > 20)
//                .defaultIfEmpty(-1)
//                .subscribe(System.out::println);

        // Switch ints from intNumbersFlux to the right user from userFlux
//        ReactiveSources.intNumbersFlux()
//                .map(id -> ReactiveSources.userFlux().filter(
//                        user -> user.getId() == id).take(2))
//                .subscribe(System.out::println);

        // Print only distinct numbers from intNumbersFluxWithRepeat
//        ReactiveSources.intNumbersFluxWithRepeat()
//                .log()
//                .distinct()
//                .subscribe(System.out::println); // -- triggers the event

        // Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
        ReactiveSources.intNumbersFluxWithRepeat()
                .distinctUntilChanged()
                .log()
                .subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
