package chapter_2.operators.operators_2_transformative;

import io.reactivex.Observable;

public class Example_23_defaultIfEmpty_switchIfEmpty {

    public static void main(String[] args) {
        System.out.println("=== defaultIfEmpty on not-empty === ");
        Observable.just("first", "second", "third", "forth")
                .map(String::length)
                .defaultIfEmpty(1)
                .subscribe(System.out::println);

        System.out.println("=== defaultIfEmpty on empty === ");
        Observable.empty()
                .defaultIfEmpty(1)
                .subscribe(System.out::println);

        System.out.println("=== switchIfEmpty on empty === ");
        Observable.empty()
                .switchIfEmpty(Observable.just("first", "second", "third"))
                .cast(String.class)
                .map(String::length)
                .subscribe(System.out::println);


    }
}
