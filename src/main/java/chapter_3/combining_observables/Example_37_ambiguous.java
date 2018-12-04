package chapter_3.combining_observables;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Example_37_ambiguous {

    public static void main(String[] args) throws InterruptedException {
        // Chooses observables that either first emits an item or sends termination
        Observable<Long> slowObservable = Observable.intervalRange(1, 5, 0, 1000, TimeUnit.MILLISECONDS);
        Observable<Long> fastObservable = Observable.intervalRange(100, 12, 0, 500, TimeUnit.MILLISECONDS);

        Observable.ambArray(slowObservable, fastObservable)
                .subscribe(System.out::println);

        System.out.println("=== short break ===");
        Thread.sleep(7000);
        System.out.println("=== starting again ===");

        Observable<Long> startsABitQuicker = Observable.intervalRange(1, 5, 0, 1000, TimeUnit.MILLISECONDS);
        Observable<Long> startsABitLonger = Observable.intervalRange(100, 3, 0, 1000, TimeUnit.MILLISECONDS);

        Observable.ambArray(startsABitQuicker, startsABitLonger)
                .subscribe(System.out::println);

        Observable<String> longObservable = Observable.just("item_1", "item_2", "item_3", "item_4", "item_5", "item_6", "item_7", "item_8", "item_9", "item_10");
        Observable<String> shortObservable = Observable.just("item_1");

        Observable.ambArray(longObservable, shortObservable)
                .subscribe(System.out::println);
    }

}
