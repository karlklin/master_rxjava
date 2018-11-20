package chapter_2.operators_1_suppressing;

import io.reactivex.Observable;

public class Example_18_take_and_skip_and_first {

    public static void main(String[] args) {
        System.out.println("=== take(2) ===");
        Observable.just("first", "second", "third", "forth")
                .take(2)
                .subscribe(System.out::println);

        System.out.println("=== takeLast(2) ===");
        Observable.just("first", "second", "third", "forth")
                .takeLast(2)
                .subscribe(System.out::println);

        System.out.println("=== skip(2) ===");
        Observable.just("first", "second", "third", "forth")
                .skip(2)
                .subscribe(System.out::println);

        System.out.println("=== skipLast(2) ===");
        Observable.just("first", "second", "third", "forth")
                .skipLast(2)
                .subscribe(System.out::println);

        System.out.println("=== first ===");
        Observable.just("first", "second", "third", "forth")
                .first("if empty")
                .subscribe(System.out::println);
    }
}
