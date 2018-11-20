package chapter_2.operators_2_transformative;

import io.reactivex.Observable;

public class Example_21_map {

    public static void main(String[] args) {
        Observable.just("first", "second", "third", "forth")
                .map(String::length)
                .subscribe(System.out::println);
    }
}
