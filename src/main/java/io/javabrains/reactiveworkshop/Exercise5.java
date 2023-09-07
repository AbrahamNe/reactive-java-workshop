package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        // TODO: Write code here
        ReactiveSources.intNumberMono().subscribe(
                x -> System.out.println(x),    // subscribe
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Completed")   // next
        );
        // Subscribe to a flux using an implementation of BaseSubscriber
        // TODO: Write code here
        ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());
        System.out.println("Press a key to end");
        System.in.read();
    }

}

class MySubscriber<T> extends BaseSubscriber {  // -- we need to ask the item using request
    // when subscription happens do this
    public void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribe happened");
        request(1); // give me two items when am requesting when ur are ready
    }

    // when event happens do this
    public void hookOnNext(Object value) {
        System.out.println(value.toString() + " received");
        request(1); // requesting 1 more
    }
}