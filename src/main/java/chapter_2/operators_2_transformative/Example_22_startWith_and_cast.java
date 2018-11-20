package chapter_2.operators_2_transformative;

import io.reactivex.Observable;

public class Example_22_startWith_and_cast {

    public static void main(String[] args) {
        System.out.println("=== cast === ");
        Observable.just("first", "second", "third", "forth")
                .cast(Object.class)
                .subscribe(System.out::println);

        System.out.println("=== startWith Zero === ");
        Observable.just("first", "second", "third", "forth")
                .startWith("zero")
                .subscribe(System.out::println);
    }
}
