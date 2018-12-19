package chapter_7_buffering_switching_throttling_windowing;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class Example_56_throttling {

    public static void main(String[] args) throws InterruptedException {
        // Throttling means receiving first or last values from given time window

        Observable.interval(1, TimeUnit.SECONDS)
                .throttleFirst(5, TimeUnit.SECONDS)
                .subscribe(interval -> System.out.println("throttling1: " + interval));

        Observable.interval(1, TimeUnit.SECONDS)
                .throttleLast(5, TimeUnit.SECONDS)
                .subscribe(interval -> System.out.println("throttling2: " + interval));

        TimeUnit.SECONDS.sleep(10);
    }

}
