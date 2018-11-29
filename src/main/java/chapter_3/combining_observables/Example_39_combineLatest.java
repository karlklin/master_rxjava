package chapter_3.combining_observables;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Example_39_combineLatest {

    public static void main(String[] args) throws InterruptedException {
        Observable<Long> slowSource = Observable.intervalRange(1, 5, 0, 1500, TimeUnit.MILLISECONDS);
        Observable<Long> fastSource = Observable.intervalRange(100, 3, 0, 300, TimeUnit.MILLISECONDS);

        Observable.combineLatest(slowSource, fastSource, (aLong, aLong2) -> aLong + "-" + aLong2)
                .subscribe(System.out::println);

        Thread.sleep(10000);
    }

}