package io.javabrains.reactiveworkshop;

import java.util.Optional;

public class Exercise1 {


    public static void main(String[] args) {

//        List<Integer> values = Arrays.asList(1, 3, 4, 7, 8, 6);
//        values.stream().forEach(value -> System.out.println(value));

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream

        StreamSources.intNumbersStream()
                .forEach(System.out::println);

        // Print numbers from intNumbersStream that are less than 5
        StreamSources.intNumbersStream().filter(number -> number < 5)
                .forEach(System.out::println);

        // Print the second and third numbers in intNumbersStream that's greater than 5

        StreamSources.intNumbersStream().filter(number -> number > 5)
                .skip(1)
                .limit(2)
                .forEach(System.out::println);

        //  Print the first number in intNumbersStream that's greater than 5.
//        //  If nothing is found, print -1

        Optional<Integer> result = StreamSources.intNumbersStream()
                .filter(number -> number > 5)
                .findFirst();
        if (result.isPresent()) {
            System.out.println(result.get());
        } else System.out.println(-1);

        // OR
        Integer value = StreamSources.intNumbersStream()
                .filter(number -> number > 5)
                .findFirst()
                .orElse(-1);
        System.out.println(value);


        // Print first names of all users in userStream
        StreamSources.userStream()
                .map(user -> user.getFirstName())
                .forEach(userName -> System.out.println(userName));

        // OR
        StreamSources.userStream()
                .forEach(name -> System.out.println(name.getFirstName()));

        System.out.println("=========");
        // Print first names in userStream for users that have IDs from number stream
        StreamSources.intNumbersStream()
                .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
                .map(user -> user.getFirstName())
                .forEach(userName -> System.out.println(userName));

        StreamSources.userStream()
                .filter(u ->
                        StreamSources.intNumbersStream()
                                .anyMatch(i -> i == u.getId()))
                .forEach(u -> System.out.println(u.getFirstName()));
    }

}

