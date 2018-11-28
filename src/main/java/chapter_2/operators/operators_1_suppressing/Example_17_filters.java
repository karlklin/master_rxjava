package chapter_2.operators.operators_1_suppressing;

import io.reactivex.Observable;

public class Example_17_filters {

    public static void main(String[] args) {
        Observable.just("first", "second", "third", "forth")
                .filter(s -> s.length() > 5)
                .subscribe(System.out::println);
    }
}
