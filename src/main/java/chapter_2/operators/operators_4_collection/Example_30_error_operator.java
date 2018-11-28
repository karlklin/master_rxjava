package chapter_2.operators.operators_4_collection;

import io.reactivex.Observable;
import io.reactivex.functions.BiConsumer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.function.Function;

public class Example_30_error_operator {

    public static void main(String[] args) {
        System.out.println("=== onErrorReturnItem ===");
        Observable.just(1, 2, 3, 0, 4, 5, 6, 7)
                .map(integer -> 10 / integer)
                .onErrorReturnItem(-1)
                .subscribe(System.out::println);

        System.out.println("=== onErrorReturn ===");
        Observable.just(1, 2, 3, 0, 4, 5, 6, 7)
                .map(integer -> 10 / integer)
                .onErrorReturn(throwable -> -1)
                .subscribe(System.out::println);

        System.out.println("=== onErrorResumeNext ===");
        Observable.just(1, 2, 3, 0, 4, 5, 6, 7)
                .map(integer -> 10 / integer)
                .onErrorResumeNext(Observable.just(10, 11))
                .subscribe(System.out::println);

    }
}
