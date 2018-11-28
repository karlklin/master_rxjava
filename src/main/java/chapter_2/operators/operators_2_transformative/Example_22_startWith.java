package chapter_2.operators.operators_2_transformative;

import io.reactivex.Observable;

public class Example_22_startWith {

    public static void main(String[] args) {
        System.out.println("=== startWith Zero === ");
        Observable.just("first", "second", "third", "forth")
                .startWith("zero")
                .subscribe(System.out::println);
    }
}
