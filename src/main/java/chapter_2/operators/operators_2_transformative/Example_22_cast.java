package chapter_2.operators.operators_2_transformative;

import io.reactivex.Observable;

public class Example_22_cast {

    public static void main(String[] args) {
        System.out.println("=== cast === ");
        Observable.just("first", "second", "third", "forth")
                .cast(Object.class)
                .subscribe(System.out::println);
    }
}
