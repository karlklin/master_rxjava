package chapter_3.combining_observables;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Example_35_contat_and_concatWith {

    public static void main(String[] args) throws InterruptedException {
        // DOES guarantee order
        Observable<Long> interval1 = Observable.intervalRange(1, 5, 1000, 1000, TimeUnit.MILLISECONDS);
        Observable<Long> interval2 = Observable.intervalRange(100, 5, 0, 1000, TimeUnit.MILLISECONDS);

        Observable.concat(interval1, interval2)
                .subscribe(System.out::println);

        Thread.sleep(10000);
    }

}
