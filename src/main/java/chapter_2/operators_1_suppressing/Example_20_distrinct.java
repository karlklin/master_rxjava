package chapter_2.operators_1_suppressing;

import io.reactivex.Observable;

public class Example_20_distrinct {

    public static void main(String[] args) {

        System.out.println("=== distinct ===");
        Observable.just("first", "second", "fist", "third", "forth", "second")
                .distinct()
                .subscribe(System.out::println);

        System.out.println("=== distinct by length ===");
        Observable.just("first", "second", "third", "forth")
                .distinct(String::length)
                .subscribe(System.out::println);

        System.out.println("=== distinctUntilChanged ===");
        Observable.just("first", "first", "second", "first", "first", "third", "first", "forth")
                .distinctUntilChanged()
                .subscribe(System.out::println);


    }
}
