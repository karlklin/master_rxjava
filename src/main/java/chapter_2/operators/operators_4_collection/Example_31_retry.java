package chapter_2.operators.operators_4_collection;

import io.reactivex.Observable;

public class Example_31_retry {

    public static void main(String[] args) {
        // retries whole Observable
        System.out.println("=== retry  ===");
        Observable.just(1, 2, 3, 0, 4, 5, 6, 7)
                .map(integer -> 10 / integer)
                .retry(1)
                .subscribe(System.out::println);
    }
}
