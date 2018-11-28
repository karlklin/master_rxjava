package chapter_2.operators.operators_1_suppressing;

import io.reactivex.Observable;

public class Example_19_takeWhile_and_skipWhile {

    public static void main(String[] args) {
        // take as long as length > 4
        System.out.println("=== takeWhile length > 5 ===");
        Observable.just("first", "second", "third", "forth")
                .takeWhile(s -> s.length() > 4)
                .subscribe(System.out::println);

        // skip as long as length > 4
        System.out.println("=== skipWhile length ===");
        Observable.just("first", "second", "third", "forth")
                .skipWhile(s -> s.length() > 4)
                .subscribe(System.out::println);
    }
}
