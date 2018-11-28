package chapter_3.combining_observables;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Example_33_merge_and_mergeWith {

    public static void main(String[] args) throws InterruptedException {
        // Important: merge DOES NOT guarantee the order
        Observable<String> source1 = Observable.just("item_1", "item_2");
        Observable<String> source2 = Observable.just("item_3", "item_4");
        Observable<String> source3 = Observable.just("item_5", "item_6");
        Observable<String> source4 = Observable.just("item_7", "item_8");
        Observable<String> source5 = Observable.just("item_9", "item_10");

        Observable.merge(source1, source2, source3, source4)
                .subscribe(item -> System.out.println("Merged_1: " + item));

        Observable.merge(Arrays.asList(source1, source2, source3, source4, source5))
                .subscribe(item -> System.out.println("Merged_2: " + item));

        source1.mergeWith(source2)
                .subscribe(System.out::println);

        Observable<Long> interval1 = Observable.intervalRange(1, 5, 1000, 1000, TimeUnit.MILLISECONDS);
        Observable<Long> interval2 = Observable.intervalRange(100, 5, 0, 1000, TimeUnit.MILLISECONDS);

        Observable.merge(interval1, interval2)
                .subscribe(System.out::println);

        Thread.sleep(10000);
    }

}
